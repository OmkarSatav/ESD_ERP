import React, {useEffect} from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "./navbar";
import EmployeeTable from "./employeeTable";
import '../styles/dashboardPages.css';


const DashboardPage = () => {
    const navigate = useNavigate();
    // const [employees, setEmployees] = useState([]);
    // const [loading, setLoading] = useState(true);

    // useEffect(() => {
    //     const fetchEmployees = async () => {
    //     try {
    //         const response = await axios.get("/auth/employees"); // Backend API to fetch employees
    //         setEmployees(response.data.data);
    //         setLoading(false);
    //     } catch (error) {
    //         console.error("Error fetching employees:", error);
    //         setLoading(false);
    //     }
    //     };

    //     fetchEmployees();
    // }, []);

    useEffect(() => {
        window.history.replaceState(null, null, window.location.href); // Replace history state
        window.onpopstate = () => {
          localStorage.removeItem("token"); // Clear token if user goes back
          window.location.href = "/"; // Redirect to Login
        };
      }, []);
    // if (loading) {
    //     return <p>Loading employees...</p>;
    // }

    const handleLogout = () => {
        localStorage.removeItem("token");
        navigate("/");
        window.location.reload(); // Reload to clear cached content
      };

    return (
        <div className="dashboard-container">
            <Navbar onLogout={handleLogout} />
            <EmployeeTable />
        </div>
    );
};

export default DashboardPage;

{/* <div className="cards-container">
                {employees.map((employee) => (
                <div key={employee.employee_id} className="employee-card">
                    <img
                    src={employee.photograph_path || "default-photo.jpg"} // Use a default image if path is null
                    alt={`${employee.first_name} ${employee.last_name}`}
                    className="employee-photo"
                    />
                    <div className="employee-details">
                    <h2>{`${employee.first_name} ${employee.last_name}`}</h2>
                    <p>Email: {employee.email}</p>
                    <p>Title: {employee.title || "No Title Assigned"}</p>
                    <p>Department: {employee.department.name}</p>
                    </div>
                </div>
                ))}
            </div> */}

