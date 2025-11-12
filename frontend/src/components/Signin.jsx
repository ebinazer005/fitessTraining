import { useEffect, useState } from "react"
import { useDispatch,useSelector } from "react-redux";
import { signinpage } from '../store/index';
import { useNavigate  } from "react-router-dom";
const  Signin= () => {


  const dispatch = useDispatch();
  const navigate =useNavigate();

  const {loading,error,userData} =useSelector((state)=> state.StoreForsingin)
    const [siginData,setSiginData] = useState({
        email : "",
        name : "",
        password : "",
        role :""
});    

const [siginMessage ,setSiginMessage]= useState(false)

// console.log(siginData.email);
// console.log(siginData.name);
// console.log(siginData.password);
// console.log(siginData.role);

console.log(userData );

    const handleChange =(event)=>{
        const {name ,value} =event.target;
        setSiginData ((prev)=>({
            ...prev,
            [name] : value
        }))  

    }
    const signin = async(event) =>{
        event.preventDefault()
        dispatch(signinpage(siginData));

    }

  
useEffect(()=>{
  if (userData == "success") {
  setSiginMessage(true);
  navigate('/')
}
},[userData])    





    return(<>

    

   {siginMessage && <p> signin successfull </p>}
        <form onSubmit={signin}>
        <h2>signin</h2>


      <div>
        <label>Email:</label>
        <input
          type="email"
          name="email"
          placeholder="Enter your email"
          value={siginData.email}
          onChange={handleChange}
          required
        />
      </div>
      <div style={{ marginTop: 10 }}>
        <label>Name:</label>
        <input
          type="text"
          name="name"
          placeholder="Enter your email"
         value={siginData.name}
          onChange={handleChange}
          required
        />
      </div>
      <div style={{ marginTop: 10 }}>
        <label>Password:</label>
        <input
          type="text"
          name="password"
          placeholder="Enter your email"
         value={siginData.password}
          onChange={handleChange}
          required
        />
      </div>

      <div style={{ marginTop: 10 }}>
        <label>:Role</label>
        <input
          type="text"
          name="role"
          placeholder="Enter your email"
           value={siginData.role}
          onChange={handleChange}
          required
        />
        </div>

      <button type="submit" style={{ marginTop: 15 }}>
        {loading ? "signin..." : "submit"}
      </button>
        </form>
    </>)
    
}
 
export default Signin;


