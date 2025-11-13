import Navbar from "./Navbar";
import  Assistent  from "./assistentAi";
import "./home.css"

const Home = () => {
    return ( <>
    <Navbar />
    <div className="home">


      <div className="home_card">    
         <h1 className="home_title"><span>The Fitness </span> Journey <br /> Start here</h1>

            <div className="flex-cards">
               <div className="first-cart"><h1>kj</h1></div>
               <div className="sec-cart"><h1>kj</h1></div>
            </div>
         
         <div className="assistant_wrapper">
            <Assistent />
         </div>  
         
      </div>
       
    </div>  
 </> );
}
 
export default Home;