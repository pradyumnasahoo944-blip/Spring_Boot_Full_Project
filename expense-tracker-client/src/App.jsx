import { useEffect, useState } from "react";
import ExpenseForm from "./Component/ExpenseForm";
import ExpenseList from "./Component/ExpenseList";
import Footer from "./Component/Footer";
import Header from "./Component/Header";
import Summary from "./Component/Summary";
import axios from "axios";

export default  function App() {
    const [expenses,setExpenses] =useState([])
     const getExpenses = async ()=>{
            try {
                const response = await axios.get("http://localhost:8080/expenses")
                 setExpenses(response.data)
                
            } catch (err) {
                console.log("Eroor is ",err);
                
                
            }
            
        }

          useEffect(()=>{
                  getExpenses()
        
                },[])
        
    return(
    <div className="min-h-screen bg-gray-100">
      <Header/>

      <main className="max-w-4xl mx-auto py-4 mt-4">
      <ExpenseForm/>
      <Summary expenses={expenses}/>
      <ExpenseList expenses={expenses}/>
      </main>

      <Footer>
        <Footer></Footer>
      </Footer>


    </div>
    )
}