import { createAsyncThunk, createSlice, } from "@reduxjs/toolkit";
import axios from "axios";

const initialState = {isloading :false,error:null,userData:null}
// const url = "https://api.api-ninjas.com/v1/exercises";

const url = "http://localhost:8080/getBashbordData";


export const fitnessThunk =createAsyncThunk("api/fitness" , async(_,{rejectWithValue})=>{
    try{
            const response = await axios.get(url)
            return response.data;
    }
    catch(error){
        return rejectWithValue(error.response?.data || "login Failed");
    }
}
);



const fitnessSlice = createSlice({
    name : "fitness",
    initialState,
    reducers:{

    },
    extraReducers :(builder)=>{
        builder 
        .addCase(fitnessThunk.fulfilled,(state,action)=>{
            state.isloading = false
            state.error = null
            state.userData = action.payload

        })
        .addCase(fitnessThunk.pending,(state)=>{
            state.isloading = true
            state.error =null
        })
        .addCase(fitnessThunk.rejected,(state,action)=>{
            state.error = action.payload
            state.isloading =false
        })
    }

})

export default fitnessSlice.reducer

// {
                //     headers : {
                //         "X-Api-Key" : "nJxDOAtR9U2wbyYOvGtT0g==kH11tkz3Lr2bnGM4"
                //     },
                   
                // }