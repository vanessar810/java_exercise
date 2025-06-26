function App() {
  const [currentPage, setCurrentPage] = React.useState('home');
  const [appointments, setAppointments] = React.useState([]);
  const [patients, setPatients] = React.useState([]);

  // Navigation component
  const Navigation = () => (
    <nav className="bg-blue-600 text-white p-4">
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

  // Home page component
  const HomePage = () => (
    <div className="container mx-auto p-6">
      <div className="text-center mb-8">
        <h2 className="text-4xl font-bold text-gray-800 mb-4">Welcome to DentalCare Clinic</h2>
        <p className="text-xl text-gray-600">Professional dental care for your entire family</p>
      </div>
      
      <div className="grid md:grid-cols-3 gap-6 mb-8">
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-tooth text-4xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">General Dentistry</h3>
          <p className="text-gray-600">Comprehensive dental care including cleanings, fillings, and preventive treatments.</p>
        </div>
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-user-md text-4xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">Specialized Care</h3>
          <p className="text-gray-600">Expert orthodontics, oral surgery, and cosmetic dentistry services.</p>
        </div>
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-calendar-alt text-4xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">Easy Scheduling</h3>
          <p className="text-gray-600">Convenient online appointment booking and flexible scheduling options.</p>
        </div>
      </div>
    </div>
  );

  // Patients page component
  const PatientsPage = () => {
    const [newPatient, setNewPatient] = React.useState({
      name: '',
      email: '',
      phone: '',
      dateOfBirth: ''
    });

    const handleAddPatient = (e) => {
      e.preventDefault();
      if (newPatient.name && newPatient.email) {
        setPatients([...patients, { ...newPatient, id: Date.now() }]);
        setNewPatient({ name: '', email: '', phone: '', dateOfBirth: '' });
      }
    };

    return (
      <div className="container mx-auto p-6">
        <h2 className="text-3xl font-bold mb-6">Patient Management</h2>
        
        <div className="grid md:grid-cols-2 gap-6">
          <div className="bg-white p-6 rounded-lg shadow-md">
            <h3 className="text-xl font-semibold mb-4">Add New Patient</h3>
            <form onSubmit={handleAddPatient} className="space-y-4">
              <input
                type="text"
                placeholder="Full Name"
                value={newPatient.name}
                onChange={(e) => setNewPatient({...newPatient, name: e.target.value})}
                className="w-full p-3 border rounded-lg"
                required
              />
              <input
                type="email"
                placeholder="Email"
                value={newPatient.email}
                onChange={(e) => setNewPatient({...newPatient, email: e.target.value})}
                className="w-full p-3 border rounded-lg"
                required
              />
              <input
                type="tel"
                placeholder="Phone Number"
                value={newPatient.phone}
                onChange={(e) => setNewPatient({...newPatient, phone: e.target.value})}
                className="w-full p-3 border rounded-lg"
              />
              <input
                type="date"
                placeholder="Date of Birth"
                value={newPatient.dateOfBirth}
                onChange={(e) => setNewPatient({...newPatient, dateOfBirth: e.target.value})}
                className="w-full p-3 border rounded-lg"
              />
              <button type="submit" className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700">
                Add Patient
              </button>
            </form>
          </div>
          
          <div className="bg-white p-6 rounded-lg shadow-md">
            <h3 className="text-xl font-semibold mb-4">Patient List</h3>
            <div className="space-y-3">
              {patients.length === 0 ? (
                <p className="text-gray-500">No patients registered yet.</p>
              ) : (
                patients.map(patient => (
                  <div key={patient.id} className="p-3 border rounded-lg">
                    <h4 className="font-semibold">{patient.name}</h4>
                    <p className="text-sm text-gray-600">{patient.email}</p>
                    <p className="text-sm text-gray-600">{patient.phone}</p>
                  </div>
                ))
              )}
            </div>
          </div>
        </div>
      </div>
    );
  };

  // Appointments page component
  const AppointmentsPage = () => {
    const [newAppointment, setNewAppointment] = React.useState({
      patientName: '',
      date: '',
      time: '',
      service: '',
      notes: ''
    });

    const handleAddAppointment = (e) => {
      e.preventDefault();
      if (newAppointment.patientName && newAppointment.date && newAppointment.time) {
        setAppointments([...appointments, { ...newAppointment, id: Date.now() }]);
        setNewAppointment({ patientName: '', date: '', time: '', service: '', notes: '' });
      }
    };

    return (
      <div className="container mx-auto p-6">
        <h2 className="text-3xl font-bold mb-6">Appointment Management</h2>
        
        <div className="grid md:grid-cols-2 gap-6">
          <div className="bg-white p-6 rounded-lg shadow-md">
            <h3 className="text-xl font-semibold mb-4">Schedule Appointment</h3>
            <form onSubmit={handleAddAppointment} className="space-y-4">
              <input
                type="text"
                placeholder="Patient Name"
                value={newAppointment.patientName}
                onChange={(e) => setNewAppointment({...newAppointment, patientName: e.target.value})}
                className="w-full p-3 border rounded-lg"
                required
              />
              <input
                type="date"
                value={newAppointment.date}
                onChange={(e) => setNewAppointment({...newAppointment, date: e.target.value})}
                className="w-full p-3 border rounded-lg"
                required
              />
              <input
                type="time"
                value={newAppointment.time}
                onChange={(e) => setNewAppointment({...newAppointment, time: e.target.value})}
                className="w-full p-3 border rounded-lg"
                required
              />
              <select
                value={newAppointment.service}
                onChange={(e) => setNewAppointment({...newAppointment, service: e.target.value})}
                className="w-full p-3 border rounded-lg"
              >
                <option value="">Select Service</option>
                <option value="cleaning">Dental Cleaning</option>
                <option value="filling">Filling</option>
                <option value="extraction">Tooth Extraction</option>
                <option value="checkup">General Checkup</option>
                <option value="orthodontics">Orthodontics</option>
              </select>
              <textarea
                placeholder="Notes"
                value={newAppointment.notes}
                onChange={(e) => setNewAppointment({...newAppointment, notes: e.target.value})}
                className="w-full p-3 border rounded-lg"
                rows="3"
              />
              <button type="submit" className="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700">
                Schedule Appointment
              </button>
            </form>
          </div>
          
          <div className="bg-white p-6 rounded-lg shadow-md">
            <h3 className="text-xl font-semibold mb-4">Upcoming Appointments</h3>
            <div className="space-y-3">
              {appointments.length === 0 ? (
                <p className="text-gray-500">No appointments scheduled.</p>
              ) : (
                appointments.map(appointment => (
                  <div key={appointment.id} className="p-3 border rounded-lg">
                    <h4 className="font-semibold">{appointment.patientName}</h4>
                    <p className="text-sm text-gray-600">{appointment.date} at {appointment.time}</p>
                    <p className="text-sm text-gray-600">{appointment.service}</p>
                    {appointment.notes && <p className="text-sm text-gray-500">{appointment.notes}</p>}
                  </div>
                ))
              )}
            </div>
          </div>
        </div>
      </div>
    );
  };

  // Services page component
  const ServicesPage = () => (
    <div className="container mx-auto p-6">
      <h2 className="text-3xl font-bold mb-6">Our Services</h2>
      
      <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-tooth text-3xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">General Dentistry</h3>
          <p className="text-gray-600 mb-4">Routine cleanings, fillings, and preventive care to maintain oral health.</p>
          <p className="text-blue-600 font-semibold">Starting at $80</p>
        </div>
        
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-smile text-3xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">Cosmetic Dentistry</h3>
          <p className="text-gray-600 mb-4">Teeth whitening, veneers, and smile makeovers for aesthetic enhancement.</p>
          <p className="text-blue-600 font-semibold">Starting at $200</p>
        </div>
        
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-cut text-3xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">Oral Surgery</h3>
          <p className="text-gray-600 mb-4">Tooth extractions, wisdom teeth removal, and surgical procedures.</p>
          <p className="text-blue-600 font-semibold">Starting at $150</p>
        </div>
        
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-align-center text-3xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">Orthodontics</h3>
          <p className="text-gray-600 mb-4">Braces, aligners, and teeth straightening treatments.</p>
          <p className="text-blue-600 font-semibold">Starting at $3000</p>
        </div>
        
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-crown text-3xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">Restorative Dentistry</h3>
          <p className="text-gray-600 mb-4">Crowns, bridges, and implants to restore damaged teeth.</p>
          <p className="text-blue-600 font-semibold">Starting at $500</p>
        </div>
        
        <div className="bg-white p-6 rounded-lg shadow-md">
          <i className="fas fa-child text-3xl text-blue-600 mb-4"></i>
          <h3 className="text-xl font-semibold mb-2">Pediatric Dentistry</h3>
          <p className="text-gray-600 mb-4">Specialized dental care for children and adolescents.</p>
          <p className="text-blue-600 font-semibold">Starting at $60</p>
        </div>
      </div>
    </div>
  );

  // Main render function
  const renderPage = () => {
    switch(currentPage) {
      case 'home': return <HomePage />;
      case 'patients': return <PatientsPage />;
      case 'appointments': return <AppointmentsPage />;
      case 'services': return <ServicesPage />;
      default: return <HomePage />;
    }
  };

  return (
    <div className="min-h-screen bg-gray-100">
      <Navigation />
      {renderPage()}
      
      <footer className="bg-gray-800 text-white p-6 mt-8">
        <div className="container mx-auto text-center">
          <p>&copy; 2024 DentalCare Clinic. All rights reserved.</p>
          <p className="text-sm text-gray-400 mt-2">Professional dental care for your entire family</p>
        </div>
      </footer>
    </div>
  );
}