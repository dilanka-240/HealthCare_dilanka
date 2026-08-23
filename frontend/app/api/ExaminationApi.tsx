const BASE_URL = "http://10.0.2.2:8080/patient";

export const addExamination = async (exam: any) => {
  const res = await fetch(`${BASE_URL}/{no}/exam`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(exam),
  });
  if (!res.ok) {
    throw new Error("Failed to add examination");
  }
  return res.json();
};

export const updateExamination = async (exam: any) => {
  const res = await fetch(`${BASE_URL}/{no}/exam/{examId}/update`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(exam),
  });
  if (!res.ok) {
    throw new Error("Failed to update examination");
  }
  return res.json();
};
