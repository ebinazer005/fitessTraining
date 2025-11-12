import './navbar.css'
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
const Navbar = () => {

    const {userdata,email} =useSelector((state)=>state.StoreLogin);
    // const email =useSelector((state)=>state.StoreLogin.email);
    
    const [logindetail,setLogindetail]=useState(false);

    console.log(userdata)

    useEffect(()=>{
         if(userdata == "success"){
        setLogindetail(true);
    }
    },[userdata])
   
    
    return ( 

        <div className="navbar">
            <div className='left-menu'>
                <ul>
                    <Link to="/dashboard"><li> dashboard </li></Link> 
                    <Link to="/"><li>home</li></Link>
                </ul>
            </div>
            {!logindetail ? <div className='right-menu'>
                <ul>
                    <Link to="/login"><li >login</li></Link>
                    <Link to="/sigin"><li >sigin</li></Link>
                </ul>
               
            </div> :<div className='right-menu'><li>{email}</li> </div>}
            
        </div>   
   );
}
 
export default Navbar;