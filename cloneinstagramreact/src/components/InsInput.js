import React from 'react'


const InsInput = props => {
    const {label, error, name, onChange} = props;
    const clasName = error ? "form-control is-invalid" : "form-control";
    return (
        <div className="form-group">
            <label>{label}</label>
            <input className={clasName} name={name}
                   onChange={onChange}/>
            <div className="invalid-feedback">
                {error}
            </div>
        </div>

    );
}

export default InsInput;