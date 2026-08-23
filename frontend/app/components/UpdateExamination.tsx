import React, { useState } from "react";
import { View, Text, TextInput, Button, Alert, StyleSheet } from "react-native";
import { updateExamination } from "../api/ExaminationApi";

export default function UpdateExamination() {
  const [exam, setExam] = useState({
    no: "",
    examId: "",
    bp: "",
    hp: "",
    wi: "",
    temp: ""
  });

  const handleChange = (field: string, value: string) => {
    setExam({ ...exam, [field]: value });
  };

  const handleSubmit = async () => {
    try {
      await updateExamination(exam);
      Alert.alert("Success", "Examination updated successfully.");
      setExam({ no: "", examId: "", bp: "", hp: "", wi: "", temp: "" });
    } catch (err) {
      console.error(err);
      Alert.alert("Error", "Could not update Examination.");
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Update Examination</Text>

      <TextInput
        placeholder="Patient No"
        value={exam.no}
        onChangeText={(t) => handleChange("no", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Exam ID"
        value={exam.examId}
        onChangeText={(t) => handleChange("examId", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Blood Pressure"
        value={exam.bp}
        onChangeText={(t) => handleChange("bp", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Heart Pressure"
        value={exam.hp}
        onChangeText={(t) => handleChange("hp", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Weight"
        value={exam.wi}
        onChangeText={(t) => handleChange("wi", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Temperature"
        value={exam.temp}
        onChangeText={(t) => handleChange("temp", t)}
        style={styles.input}
      />

      <Button title="Update Examination" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20 },
  title: { fontSize: 20, marginBottom: 10 },
  input: { borderWidth: 1, borderColor: "#ccc", padding: 8, marginBottom: 10 }
});
