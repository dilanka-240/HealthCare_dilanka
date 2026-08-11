import { addExamination } from './ExaminationApi.tsx';

const API_URL = "http://10.0.2.2:8080/patient/treat"

export const addTreatment = async (treat: any) => {
  const res = await fetch(API_URL, {
    method: "POST",
    headers: {'Content-Type': 'application/json' },
    body: JSON.stringify(treat),
  });

  if(!res.ok) {
    throw new Error("Failed to add treatment");
  }
  return res.json();
}