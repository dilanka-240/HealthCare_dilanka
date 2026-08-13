const API_URL = "http://10.0.2.2:8080/patient/exam";

export const addExamination = async (exam: any) => {
  const res = await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(exam),
  });

  if (!res.ok) {
    throw new Error('Faild to add examiantion');
  }
  return res.json();
};

