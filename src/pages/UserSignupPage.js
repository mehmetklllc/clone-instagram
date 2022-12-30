import React from "react";
import {signUp} from "../api/userApi";
import Input from "../components/InsInput";
import {ToastContainer, toast} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {withTranslation} from 'react-i18next'

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

    render() {
        const {pendingApiCall} = this.state;
        return (

            <div className="border border-3 rounded">
                <div className="container">
                    <form>
                        <h1 className="text-center">Instagram</h1>
                        <h1 className="text-center">{this.props.t('Sign Up')}</h1>

                        <div className="mb-3">
                            <label className="form-label">{this.props.t('Username')}</label>
                            <Input className="form-control" name="username"  onChange={this.onChange}></Input>
                        </div>
                        <div className="mb-3">
                            <label className="form-label">Display Name: </label>
                            <input className="form-control" name="displayName" onChange={this.onChange}/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label">Password : </label>
                            <input className="form-control" type="password" name="password" onChange={this.onChange}
                                   aria-describedby="passwordHelpBlock"/>
                        </div>

                        <div className="mb-3">
                            <label className="form-label">Password Repeat : </label>
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
                                    <span class="spinner-border spinner-border-sm"></span>} Sing Up
                            </button>
                        </div>


                    </form>
                </div>
                <ToastContainer/>
            </div>);
    }
}

const UserSignupPageWithTranslate = withTranslation()(UserSignupPage);
export default UserSignupPageWithTranslate