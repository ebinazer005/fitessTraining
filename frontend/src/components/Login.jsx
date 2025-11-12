import { useEffect, useState } from "react";
import { login } from "../store/login";
import { useSelector, useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { signinpage } from "../store";

const Login = () => {

    const navigate =useNavigate(); //for navigation

    const dispatch = useDispatch() //for update the redux 
    const { loading, error, userdata } = useSelector((state) => state.StoreLogin) //get the value from redux

    const [logindata, setLogindata] = useState({
        email: "",
        password: ""
    }) 

    const [loginMessage,setLoginmessage] =useState(false);

    console.log(logindata.email ,loginMessage);

    // storing the use login data in useState
    const handleLoginData = (event) => {
        const { name, value } = event.target;

        setLogindata((prev) => ({
            ...prev,
            [name]: value
        }))
    } 

    //sed the useState data to redux via dispatch
    const sendlogindata = (event) => {
        event.preventDefault();
        dispatch(login(logindata));
    }

    //get the status from redux userdata
    useEffect(()=>{
        if(userdata === "success"){
            setLoginmessage(true);
            navigate("/")
        }
    },[userdata])
    return (
        <div>
            {loginMessage ? "sucess":"username or password are wrong"}
            
            <form onSubmit={sendlogindata}>

                <div>
                    <label>Email</label>
                    <input type="email" name="email" value={logindata.email} placeholder="enter your register email" onChange={handleLoginData} />
                </div>
                <div>
                    <label>password</label>
                    <input type="text" name="password" value={logindata.password} onChange={handleLoginData} />
                </div>
                <button>login</button>

            </form>
            <button onClick={()=>{navigate("/sigin")}}>sigin</button>
        </div>);
}

export default Login;