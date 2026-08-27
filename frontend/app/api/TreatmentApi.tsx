const API_URL = "http://10.0.2.2:8080/patient/{no}/treat";

export const addTreatmentApi = async (treat: any) => {
  const url = API_URL.replace("{no}", treat.no);
  const res = await fetch(url, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(treat),
  });

  if (!res.ok) {
    throw new Error("Failed to add treatment");
  }
  return res.json();
};

export const updateTreatmentApi = async (treat: any) => {
  const url = `http://10.0.2.2:8080/patient/${treat.no}/treat/${treat.treatId}/update`;
  const res = await fetch(url, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(treat),
  });

  if (!res.ok) {
    throw new Error("Failed to update treatment");
  }
  return res.json();
};
