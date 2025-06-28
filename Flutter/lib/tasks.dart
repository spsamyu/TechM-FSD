import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/services.dart';
import 'dart:convert';

class GardenTasksPage extends StatefulWidget {
  @override
  _GardenTasksPageState createState() => _GardenTasksPageState();
}

class _GardenTasksPageState extends State<GardenTasksPage> {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  List<dynamic> _tasks = [];
  String _parentPassword = "parent@code"; // Set parent password

  @override
  void initState() {
    super.initState();
    _loadGardenTasks();
  }

  Future<void> _loadGardenTasks() async {
    String data = await rootBundle.loadString('assets/garden_tasks.json');
    setState(() {
      _tasks = json.decode(data);
    });
  }

  void _showPasswordDialog(String task, double growthPoints) {
    TextEditingController _passwordController = TextEditingController();

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
          backgroundColor: Colors.white,
          title: Text("Parent Approval Required", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text("Enter parent password to confirm completion of garden task:",
                  textAlign: TextAlign.center, style: TextStyle(fontSize: 16, color: Colors.black)),
              SizedBox(height: 10),
              TextField(
                controller: _passwordController,
                obscureText: true,
                decoration: InputDecoration(
                  labelText: "Password",
                  border: OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
                ),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context),
              child: Text("Cancel", style: TextStyle(fontSize: 18, color: Colors.green.shade700)),
            ),
            ElevatedButton(
              onPressed: () async {
                if (_passwordController.text == _parentPassword) {
                  await _updateGrowth(growthPoints);
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text("🌱 $growthPoints seeds added for '$task'!")),
                  );
                  Navigator.pop(context);
                } else {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text("Incorrect password!")),
                  );
                }
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.green.shade700,
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
              ),
              child: Text("Confirm", style: TextStyle(fontSize: 18, color: Colors.white)),
            ),
          ],
        );
      },
    );
  }

  Future<void> _updateGrowth(double growthPoints) async {
    DocumentSnapshot snapshot = await _firestore.collection('garden').doc('child').get();
    double currentGrowth = snapshot.exists ? (snapshot['growth'] ?? 0.0) : 0.0;
    double updatedGrowth = currentGrowth + growthPoints;

    await _firestore.collection('garden').doc('child').set({
      'growth': updatedGrowth,
      'timestamp': FieldValue.serverTimestamp(),
    });

    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      backgroundColor: Colors.white,
      title: Text("Nurture Your Garden", style: TextStyle(fontSize: 26, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
      content: _tasks.isEmpty
          ? Center(child: CircularProgressIndicator())
          : SingleChildScrollView(
              child: Column(
                children: _tasks.map((task) {
                  return Card(
                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
                    margin: EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                    elevation: 5,
                    child: CheckboxListTile(
                      contentPadding: EdgeInsets.all(12),
                      title: Text(
                        task['task'],
                        style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.green.shade700),
                      ),
                      subtitle: Text(
                        "Growth Points: 🌱 ${task['reward']}",
                        style: TextStyle(fontSize: 18, color: Colors.black),
                      ),
                      value: false,
                      onChanged: (bool? value) {
                        if (value == true) {
                          _showPasswordDialog(task['task'], task['reward'].toDouble());
                        }
                      },
                      activeColor: Colors.green.shade700,
                    ),
                  );
                }).toList(),
              ),
            ),
      actions: [
        TextButton(
          onPressed: () => Navigator.pop(context),
          child: Text("Close", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
        ),
      ],
    );
  }
}
