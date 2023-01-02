import React from "react";
import {withTranslation} from 'react-i18next'
import Input from "../components/InsInput";
import {changeLanguage, login} from "../api/userApi";

class LoginPage extends React.Component {

    state = {
        username: null, password: null
    }

    onChange = event => {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        })
    }

    onClickLogin = event => {
        event.preventDefault();
        const {username, password} = this.state;
        const creds =
            {
                username,
                password
            }
        login(creds);
    }
    onChangeLanguage = language => {
        const {i18n} = this.props;
        i18n.changeLanguage(language);
        changeLanguage(language);
    }

    render() {
        return (

            <form>
                <div className="container">
                    <h1 className="text-center">{this.props.t('Login')}</h1>
                    <div className="mb-3">
                        <label className="form-label">{this.props.t('Username')}</label>
                        <Input className="form-control" name="username"
                               onChange={this.onChange}></Input>

                    </div>
                    <div className="mb-3">
                        <label className="form-label">{this.props.t('Password')}</label>
                        <input className="form-control" type="password" name="password"
                               onChange={this.onChange}
                               aria-describedby="passwordHelpBlock"/>
                    </div>


                    <div className="text-center mb-3">
                        <button
                            className="btn btn-primary"
                            onClick={this.onClickLogin}

                        >
                            {this.props.t('Login')}
                        </button>
                    </div>
                    <br/>
                    <img className='text-center' src="https://flagsapi.com/TR/flat/24.png"
                         onClick={() => this.onChangeLanguage('tr')}/>
                    <img className='text-center' src="https://flagsapi.com/GB/flat/24.png"
                         onClick={() => this.onChangeLanguage('en')}/>
                </div>
            </form>);
    }
}


const UserSignupPageWithTranslate = withTranslation()(LoginPage);
export default UserSignupPageWithTranslate