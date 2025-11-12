import singin from "./index";
import login from "./login";
import  Assistent  from "./aiAssistent";
import fitnessSlice  from "./fitnessapi";

import { configureStore } from "@reduxjs/toolkit";




const store = configureStore ({

    reducer:{
        StoreForsingin:singin,
        StoreLogin:login,
        StoreAssistent:Assistent,
        StoreFittness : fitnessSlice
         
    }
})

export default store;