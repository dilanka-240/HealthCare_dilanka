const BASE_URL = "http://10.0.2.2:8080/patient";

interface InvestigationData {
  no: string;
  invId: string;
  inv_details: string;
}

export const updateInvestigation = async (data: InvestigationData) => {
  const no = Number(data.no);
  const invId = Number(data.invId);

  const res = await fetch(`${BASE_URL}/${no}/inv/${invId}/update`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      no,
      inv_id: invId,
      inv_details: data.inv_details,
    }),
  });

  if (!res.ok) {
    throw new Error("Failed to update investigation");
  }

  return res.json();
};
