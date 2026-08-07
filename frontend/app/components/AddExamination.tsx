import React, { useState } from "react";
import { View, Text, TextInput, Button, Alert, StyleSheet } from "react-native";
import { addExamination } from "../api/ExaminationApi";

export default function AddExamination() {
  const [exam, setExam] = useState({
    no: "",
    examId: "",
    exam_date: "",
    hp: "",
    bp: "",
    wi: "",
    temp: ""
  });

  const handleChange = (field: string, value: string) => {
    setExam({ ...exam, [field]: value });
  };

  const handleSubmit = async () => {
    try {
      await addExamination(exam);
      Alert.alert("Success", "Examination added successfully.");
      setExam({ no: "", examId: "", exam_date: "", hp: "", bp: "", wi: "", temp: "" });
    } catch (err) {
      console.error(err);
      Alert.alert("Error", "Could not add Examination.");
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Add Examination</Text>

      <TextInput
        placeholder="No"
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
        placeholder="Date (YYYY-MM-DD)"
        value={exam.exam_date}
        onChangeText={(t) => handleChange("exam_date", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Heart Pulse"
        value={exam.hp}
        onChangeText={(t) => handleChange("hp", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Blood Pressure"
        value={exam.bp}
        onChangeText={(t) => handleChange("bp", t)}
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

      <Button title="Add Examination" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20 },
  title: { fontSize: 20, marginBottom: 10 },
  input: { borderWidth: 1, borderColor: "#ccc", padding: 8, marginBottom: 10 }
});
