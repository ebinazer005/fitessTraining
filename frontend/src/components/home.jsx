import Navbar from "./Navbar";
import  Assistent  from "./assistentAi";
import "./home.css"

const Home = () => {
    return ( <>
    <Navbar />
     <h1 className="home_title"><span>The Fitness </span> Journey <br /> Start here</h1>
     <div className="home"> */


      

            <div className="flex-cards">
               <div>
                  <h2 className="card-title"><span>UNLEASH YOUR</span> POTANTIAL</h2>
               <p className="card-desc">see real program with expert guidence and Ebinazer Training methods Get Started and unloack a through healthier you</p>
               </div>
               
               <div className="first-cart">
                  <img src="/public/home/pexels-panther-1547248.jpg"/>
                  
               </div>
               <div className="sec-cart">
                  <img src="/public/home/pexels-pixabay-416778.jpg"/>
                 
               </div>
               <div className="sec-card-title">
                  <h3 >BUILD YOUR MUSCLE</h3>
                  <h3 >BUILD YOUR MUSCLE</h3>
                  <h3 >BUILD YOUR MUSCLE</h3>
               
               </div>
              
            </div>
         
           
         
      {/* </div> */}
       <div className="assistant_wrapper">
            <Assistent />
         </div>
     </div>   
     
 </> );
}
 
export default Home;