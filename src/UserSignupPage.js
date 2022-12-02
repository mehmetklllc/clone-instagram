import React from "react";
import axios from "axios";

class UserSignupPage extends React.Component {
    state = {
        username: null, displayName: null, password: null, passwordRepeat: null
    }

    onChange = event => {
        const {name, value} = event.target;

        this.setState({
            [name]: value
        });
    }

    onClickSignup = event => {
        event.preventDefault();
        const {username, displayName, password} = this.state;
        const body = {
            username,
            displayName,
            password
        }
        axios.post('/api/create-user', body);
    };

    render() {

        return (
            <div className="border border-3 rounded ">
                <div className="container">
                    <form>
                        <h1 className="text-center">Instagram</h1>
                        <h1 className="text-center">Sign Up</h1>
                        <div className="mb-3">
                            <label className="form-label">Username : </label>
                            <input className="form-control" name="username" onChange={this.onChange}/>
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
                            <button className="btn btn-outline-primary" onClick={this.onClickSignup}>Sing Up</button>
                        </div>

                    </form>
                </div>
            </div>);
    }
}

export default UserSignupPage;