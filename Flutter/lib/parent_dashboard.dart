import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'savings.dart';

class ParentDashboard extends StatelessWidget {
  final TextEditingController _amountController = TextEditingController();
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  Future<void> _setAllowance(BuildContext context) async {
    double newAmount = double.tryParse(_amountController.text) ?? 0.0;

    if (newAmount <= 0) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("Enter a valid amount!")),
      );
      return;
    }

    DocumentSnapshot snapshot = await _firestore.collection('allowance').doc('child').get();
    double currentAmount = snapshot.exists ? (snapshot['amount'] ?? 0.0) : 0.0;

    double updatedAmount = currentAmount + newAmount;

    await _firestore.collection('allowance').doc('child').set({
      'amount': updatedAmount,
      'timestamp': FieldValue.serverTimestamp(),
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text("🌿 Allowance added to your garden fund!")),
    );

    _amountController.clear();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Parent Garden Tools', style: TextStyle(fontWeight: FontWeight.bold, color: Colors.white)),
        backgroundColor: Colors.green.shade600,
      ),
      body: Stack(
        children: [
          Container(
            decoration: BoxDecoration(
              image: DecorationImage(
                image: AssetImage("assets/garden_bg.png"), // Suggested: Replace with leafy or garden image
                fit: BoxFit.cover,
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(20.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                SizedBox(height: 20),
                Text(
                  'Plant Monthly Seeds (Allowance)',
                  style: TextStyle(
                    fontSize: 26,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                  textAlign: TextAlign.center,
                ),
                SizedBox(height: 20),
                TextField(
                  controller: _amountController,
                  keyboardType: TextInputType.number,
                  decoration: InputDecoration(
                    labelText: "Enter Seed Coins (₹)",
                    filled: true,
                    fillColor: Colors.white.withOpacity(0.9),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(15),
                    ),
                  ),
                ),
                SizedBox(height: 15),
                ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.green.shade600,
                    padding: EdgeInsets.symmetric(horizontal: 30, vertical: 12),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(20),
                    ),
                  ),
                  onPressed: () => _setAllowance(context),
                  child: Text('Add to Garden', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
                ),
                SizedBox(height: 15),
                StreamBuilder<DocumentSnapshot>(
                  stream: _firestore.collection('allowance').doc('child').snapshots(),
                  builder: (context, snapshot) {
                    if (snapshot.connectionState == ConnectionState.waiting) {
                      return CircularProgressIndicator();
                    }
                    if (!snapshot.hasData || !snapshot.data!.exists) {
                      return Text('No data available', style: TextStyle(color: Colors.white));
                    }
                    return Text(
                      'Check the current garden growth in savings view.',
                      style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white),
                      textAlign: TextAlign.center,
                    );
                  },
                ),
                SizedBox(height: 15),
                ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.green.shade600,
                    padding: EdgeInsets.symmetric(horizontal: 30, vertical: 12),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(20),
                    ),
                  ),
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => SavingsPage()),
                    );
                  },
                  child: Text('View Garden Savings', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
