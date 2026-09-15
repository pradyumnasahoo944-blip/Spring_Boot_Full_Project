import { useEffect, useState } from "react";
import ExpenseForm from "./Component/ExpenseForm";
import ExpenseList from "./Component/ExpenseList";
import Footer from "./Component/Footer";
import Header from "./Component/Header";
import Summary from "./Component/Summary";
import axios from "axios";
import expenseService from "./services/expenseService";


export default  function App() {
    const [expenses,setExpenses] =useState([])
    const[editingExpense,setEditingExpense]=useState(null)
     const getExpenses = async ()=>{
            try {
                const response = await expenseService.getExpenses()
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
      <ExpenseForm
      getExpenses={getExpenses} 
      editingExpense ={editingExpense}
      setEditingExpense={setEditingExpense}
      />
      <Summary expenses={expenses}/>
      <ExpenseList expenses={expenses} getExpenses={getExpenses} setEditingExpense={setEditingExpense}/>

      </main>

      <Footer>
        <Footer></Footer>
      </Footer>


    </div>
    )
}