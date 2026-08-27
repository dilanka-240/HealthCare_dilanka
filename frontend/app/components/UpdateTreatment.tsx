import React, { useState } from "react";
import { View, Text, TextInput, Button, Alert, StyleSheet } from "react-native";
import { updateTreatmentApi } from "../api/TreatmentApi";

export default function UpdateTreatment() {
  const [treat, setTreat] = useState({
    no: "",
    treatId: "",
    treat_details: ""
  });

  const handleChange = (field: string, value: string) => {
    setTreat({ ...treat, [field]: value });
  };

  const handleSubmit = async () => {
    try {
      await updateTreatmentApi(treat);
      Alert.alert("Success", "Treatment updated successfully.");
      setTreat({ no: "", treatId: "", treat_details: "" });
    } catch (err) {
      console.error(err);
      Alert.alert("Error", "Could not update Treatment.");
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Update Treatment</Text>

      <TextInput
        placeholder="Patient No"
        value={treat.no}
        onChangeText={(t) => handleChange("no", t)}
        style={styles.input}
        keyboardType="numeric"
      />

      <TextInput
        placeholder="Treat ID"
        value={treat.treatId}
        onChangeText={(t) => handleChange("treatId", t)}
        style={styles.input}
        keyboardType="numeric"
      />

      <TextInput
        placeholder="Treatment Details"
        value={treat.treat_details}
        onChangeText={(t) => handleChange("treat_details", t)}
        style={styles.input}
        multiline
        numberOfLines={3}
      />

      <Button title="Update Treatment" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20 },
  title: { fontSize: 20, marginBottom: 10 },
  input: { borderWidth: 1, borderColor: "#ccc", padding: 8, marginBottom: 10 }
});
