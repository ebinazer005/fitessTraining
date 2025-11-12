from langchain_core.prompts import ChatPromptTemplate;
from langchain_core.output_parsers import StrOutputParser;
from langchain_community.llms import Ollama;
# import streamlit as st;
from fastapi import FastAPI  # "pip install fastapi uvicorn" fastapi is for build api - uvicorn: the ASGI server to run your app
import uvicorn
from pydantic import BaseModel
from fastapi.middleware.cors import CORSMiddleware




# st.title("ebi's assistent");
# input_txt = st.text_input("please enter the query" );

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins =["*"],
    allow_methods=["*"],
    allow_headers=["*"]
)

class QueryRequest(BaseModel):
    query:str

prompt=ChatPromptTemplate.from_messages(
    [("system","your are a helpful AI assistent , your name is ebi Assistent.  "
               "only answer fitness related query and hi,hello. "
               "otherwise politly say 'i am a fittness assistent ask related that.' "),
     ("user","user query:{query}")])
llm = Ollama(model="tinyllama")
output =StrOutputParser()

chain=prompt|llm|output
#
# if input_txt:
#     st.write(chain.invoke({"query" : input_txt}))

@app.post("/assistent")

def ask(q:QueryRequest):
    response = chain.invoke({"query" : q.query})
    return {"response" :response}

if __name__ == "__main__":
    uvicorn.run(app,host="0.0.0.0",port=8000);


# to run this app "uvicorn filename:app --reload"


