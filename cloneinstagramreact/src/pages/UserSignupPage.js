import React from "react";
import {signUp, changeLanguage} from "../api/userApi";
import Input from "../components/InsInput";
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {withTranslation} from 'react-i18next'
import logo from "../logo.svg";

class UserSignupPage extends React.Component {
    state = {
        username: null,
        displayName: null, password: null, passwordRepeat: null, pendingApiCall: false,
        errors: {}
    }

    onChange = event => {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        });
    }


    onClickSignup = async event => {
        event.preventDefault();
        const {username, displayName, password, passwordRepeat} = this.state;
        const body = {
            username,
            displayName,
            password,
            passwordRepeat
        }


        this.setState({pendingApiCall: true});
        try {

            const response = await signUp(body);
            toast.success(response.data.responseMessage, {
                position: toast.POSITION.BOTTOM_RIGHT
            });
        } catch (error) {

            this.setState({errors: error.response.data});
            toast.error(error.response.data.data.message, {
                position: toast.POSITION.BOTTOM_RIGHT
            });

        }
        this.setState({pendingApiCall: false});

        /*signUp(body)
            .then(response => {
                this.setState({pendingApiCall: false, login: "memo"})
            }).catch(error => {
            this.setState({pendingApiCall: false})
        });*/
    };


    onChangeLanguage = language => {
        const {i18n} = this.props;
        i18n.changeLanguage(language);
        changeLanguage(language);
    }

    render() {
        const {pendingApiCall} = this.state;
        return (
            <div className="container">
                <div className="row">
                    <div className="col">
                        <img
                            src="https://imageio.forbes.com/specials-images/imageserve/5fac4edfacc6b52b3dbbdfb5/instagram-reels/960x0.jpg?format=jpg&width=600"/>
                        <br/>
                        <div className="container">
                            <div className="col">a</div>
                            <div className="col">b</div>
                        </div>
                    </div>
                    <div className="col-5">
                        <div className="border border-3 rounded p-lg-5">
                            <div className="container">
                                <form>

                                    <h1 className="text-center">Instagram</h1>
                                    <h1 className="text-center">{this.props.t('Sign Up')}</h1>

                                    <div className="mb-3">
                                        <label className="form-label">{this.props.t('Username')}</label>
                                        <Input className="form-control" name="username"
                                               onChange={this.onChange}></Input>
                                    </div>
                                    <div className="mb-3">
                                        <label className="form-label">{this.props.t('Display Name')}</label>
                                        <input className="form-control" name="displayName" onChange={this.onChange}/>
                                    </div>
                                    <div className="mb-3">
                                        <label className="form-label">{this.props.t('Password')}</label>
                                        <input className="form-control" type="password" name="password"
                                               onChange={this.onChange}
                                               aria-describedby="passwordHelpBlock"/>
                                    </div>

                                    <div className="mb-3">
                                        <label className="form-label">{this.props.t('Password Repeat')}</label>
                                        <input className="form-control" type="password" name="passwordRepeat"
                                               onChange={this.onChange}/>
                                    </div>
                                    <div className="text-center">
                                        <button
                                            className="btn btn-primary"
                                            onClick={this.onClickSignup}
                                            disabled={pendingApiCall}
                                        >
                                            {pendingApiCall &&
                                                <span className="spinner-border spinner-border-sm"></span>}
                                            {this.props.t('Sing Up')}
                                        </button>
                                        <div>
                                            <br/>
                                            <br/>
                                            <img src="https://flagsapi.com/TR/flat/24.png"
                                                 onClick={() => this.onChangeLanguage('tr')}/>
                                            <img src="https://flagsapi.com/GB/flat/24.png"
                                                 onClick={() => this.onChangeLanguage('en')}/>

                                        </div>
                                    </div>
                                </form>
                            </div>
                            <ToastContainer/>
                        </div>
                    </div>

                </div>

            </div>

        );
    }
}

const UserSignupPageWithTranslate = withTranslation()(UserSignupPage);
export default UserSignupPageWithTranslate