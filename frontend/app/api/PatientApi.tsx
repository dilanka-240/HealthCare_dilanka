const API_URL = "http://10.0.2.2:8080/patients";

export const createPatient = async (patient: any) => {
  const res = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(patient),
  });
  return res.json();
};

export const getPatients = async () => {
  const res = await fetch(API_URL);
  return res.json();
};
