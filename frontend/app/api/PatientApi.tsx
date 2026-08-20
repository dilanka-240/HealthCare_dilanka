const BASE_URL = "http://10.0.2.2:8080/patient";
const API_URL = `${BASE_URL}/create`;

export const createPatient = async (patient: any) => {
  const res = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(patient),
  });
  return res.json();
};

export const getPatientInfo = async (no: string | number) => {
  const res = await fetch(`${BASE_URL}/info/${no}`);
  if (!res.ok) {
    throw new Error(`Failed to fetch patient info with status: ${res.status}`);
  }
  return res.json();
};

export const getPatients = async () => {
  const res = await fetch(API_URL);
  return res.json();
};

