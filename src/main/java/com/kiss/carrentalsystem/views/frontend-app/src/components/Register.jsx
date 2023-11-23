import {  useState } from "react";
import axios from "axios";

function Register() {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [phoneNo, setPhoneNo] = useState("");
    const [address, setAddress] = useState("");
    const [dateOfBirth, setDateOfBirth] = useState("");


    async function save(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8085/user/save", {
                name: name,
                email: email,
                password: password,
                phoneNo: phoneNo,
                address: address,
                dateOfBirth: dateOfBirth,
            });
            alert("User Registation Successfully");

        } catch (err) {
            alert(err);
        }
    }

    return (
        <div>
            <div class="container mt-4" >
                <div class="card">
                    <h1>Registation</h1>

                    <form>
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text"  class="form-control" id="name" placeholder="Enter Name"

                                   value={name}
                                   onChange={(event) => {
                                       setName(event.target.value);
                                   }}
                            />

                        </div>

                        <div class="form-group">
                            <label>Email</label>
                            <input type="email"  class="form-control" id="email" placeholder="Enter Email"

                                   value={email}
                                   onChange={(event) => {
                                       setEmail(event.target.value);
                                   }}

                            />

                        </div>

                        <div className="form-group">
                            <label>Phone Number</label>
                            <input type="phoneNo" className="form-control" id="phoneNo" placeholder="Enter phone number"

                                   value={phoneNo}
                                   onChange={(event) => {
                                       setPhoneNo(event.target.value);
                                   }}

                            />
                        </div>

                        <div className="form-group">
                            <label>Address</label>
                            <input type="address" className="form-control" id="address" placeholder="Enter address"

                                   value={address}
                                   onChange={(event) => {
                                       setAddress(event.target.value);
                                   }}

                            />
                        </div>


                        <div className="form-group">
                            <label>Date Of Birth</label>
                            <input type="dateOfBirth" className="form-control" id="dateOfBirth" placeholder="Enter date of birth"

                                   value={dateOfBirth}
                                   onChange={(event) => {
                                       setDateOfBirth(event.target.value);
                                   }}

                            />
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <input type="password"  class="form-control" id="password" placeholder="Enter password"

                                   value={password}
                                   onChange={(event) => {
                                       setPassword(event.target.value);
                                   }}

                            />
                        </div>

                        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Save</button>

                    </form>
                </div>
            </div>
        </div>
    );
}

export default Register;