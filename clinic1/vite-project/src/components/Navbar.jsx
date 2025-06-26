// Navigation component
  const Navbar = ({ currentPage, setCurrentPage }) => (
    <nav className="bg-blue-400 text-white p-4">
      <div className="container mx-auto flex justify-between items-center">
        <h1 className="text-2xl font-bold">DentalCare Clinic</h1>
        <div className="space-x-4">
          <button 
            onClick={() => setCurrentPage('home')}
            className={`px-4 py-2 rounded ${currentPage === 'home' ? 'bg-blue-800' : 'hover:bg-blue-700'}`}
          >
            Home
          </button>
          <button 
            onClick={() => setCurrentPage('patients')}
            className={`px-4 py-2 rounded ${currentPage === 'patients' ? 'bg-blue-800' : 'hover:bg-blue-700'}`}
          >
            Patients
          </button>
          <button 
            onClick={() => setCurrentPage('appointments')}
            className={`px-4 py-2 rounded ${currentPage === 'appointments' ? 'bg-blue-800' : 'hover:bg-blue-700'}`}
          >
            Appointments
          </button>
          <button 
            onClick={() => setCurrentPage('services')}
            className={`px-4 py-2 rounded ${currentPage === 'services' ? 'bg-blue-800' : 'hover:bg-blue-700'}`}
          >
            Services
          </button>
        </div>
      </div>
    </nav>
  );
  export default Navbar