import React, {useEffect} from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "./navbar";
import EmployeeTable from "./employeeTable";
import '../styles/dashboardPages.css';


const DashboardPage = () => {
    const navigate = useNavigate();

    useEffect(() => {
        window.history.replaceState(null, null, window.location.href); // Replace history state
        window.onpopstate = () => {
          localStorage.removeItem("token"); // Clear token if user goes back
          window.location.href = "/"; // Redirect to Login
        };
      }, []);

    const handleLogout = () => {
        localStorage.removeItem("token");
        navigate("/");
        window.location.reload(); // Reload to clear cached content
      };

    return (
        <div className="dashboard-container">
            <Navbar onLogout={handleLogout} />
            <EmployeeTable token={localStorage.getItem('token')} />
        </div>
    );
};

export default DashboardPage;
