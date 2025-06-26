  import React from 'react'
// Patients page component
  const Patient = () => {
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
              {Patient.length === 0 ? (
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
  export default Patient