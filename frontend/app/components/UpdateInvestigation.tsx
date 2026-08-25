import React, { useState } from "react";
import { View, Text, TextInput, Button, Alert, StyleSheet } from "react-native";
import { updateInvestigation } from "../api/InvestigationApi";

export default function UpdateInvestigation() {
  const [inv, setInv] = useState({
    no: "",
    invId: "",
    inv_details: ""
  });

  const handleChange = (field: string, value: string) => {
    setInv({ ...inv, [field]: value });
  };

  const handleSubmit = async () => {
    try {
      await updateInvestigation(inv);
      Alert.alert("Success", "Investigation updated successfully.");
      setInv({ no: "", invId: "", inv_details: "" });
    } catch (err) {
      console.error(err);
      Alert.alert("Error", "Could not update Investigation.");
    }
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Update Investigation</Text>

      <TextInput
        placeholder="Patient No"
        value={inv.no}
        onChangeText={(t) => handleChange("no", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Investigation ID"
        value={inv.invId}
        onChangeText={(t) => handleChange("invId", t)}
        style={styles.input}
      />

      <TextInput
        placeholder="Investigation Details"
        value={inv.inv_details}
        onChangeText={(t) => handleChange("inv_details", t)}
        style={styles.input}
        multiline
      />

      <Button title="Update Investigation" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20 },
  title: { fontSize: 20, marginBottom: 10 },
  input: { borderWidth: 1, borderColor: "#ccc", padding: 8, marginBottom: 10 }
});
