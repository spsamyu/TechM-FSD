import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class SavingsPage extends StatelessWidget {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('🌱 Garden of Savings', style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Colors.white)),
        backgroundColor: Colors.green.shade600,
        centerTitle: true,
      ),
      body: Container(
        child: Column(
          children: [
            SizedBox(height: 20),
            StreamBuilder<DocumentSnapshot>(
              stream: _firestore.collection('allowance').doc('child').snapshots(),
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Padding(
                    padding: const EdgeInsets.symmetric(vertical: 40.0),
                    child: Center(child: CircularProgressIndicator()),
                  );
                }

                if (!snapshot.hasData || !snapshot.data!.exists) {
                  return Padding(
                    padding: const EdgeInsets.symmetric(vertical: 40.0, horizontal: 16.0),
                    child: Center(
                      child: Text(
                        'Seeds Saved: ₹0.00',
                        style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold, color: Colors.green.shade500),
                        textAlign: TextAlign.center,
                      ),
                    ),
                  );
                }

                var balanceData = snapshot.data!.data() as Map<String, dynamic>;
                num? balanceAmount = balanceData['amount'] as num?;
                String formattedBalance = balanceAmount?.toStringAsFixed(2) ?? '0.00';

                return Padding(
                  padding: const EdgeInsets.symmetric(vertical: 40.0, horizontal: 16.0),
                  child: Center(
                    child: Text(
                      'Seeds Saved: ₹$formattedBalance',
                      style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold, color: Colors.green.shade500),
                      textAlign: TextAlign.center,
                    ),
                  ),
                );
              },
            ),
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 40.0, horizontal: 60.0),
              child: Image.asset(
                'assets/garden_savings.png',
                height: 220,
                fit: BoxFit.contain,
                semanticLabel: 'Garden saving illustration',
              ),
            ),
            Expanded(
              child: StreamBuilder<QuerySnapshot>(
                stream: _firestore.collection('transactions').orderBy('timestamp', descending: true).snapshots(),
                builder: (context, snapshot) {
                  if (snapshot.connectionState == ConnectionState.waiting) {
                    return Center(child: CircularProgressIndicator());
                  }
                  if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
                    return Center(
                      child: Text(
                        "No garden activity yet!",
                        style: TextStyle(fontSize: 18, fontWeight: FontWeight.w500, color: Colors.grey),
                      ),
                    );
                  }

                  var transactions = snapshot.data!.docs;
                  List<Map<String, dynamic>> donations = [];
                  List<Map<String, dynamic>> purchases = [];

                  for (var doc in transactions) {
                    var data = doc.data() as Map<String, dynamic>;
                    if (data['type'] == 'donation') {
                      donations.add(data);
                    } else if (data['type'] == 'purchase') {
                      purchases.add(data);
                    }
                  }

                  return ListView(
                    padding: EdgeInsets.fromLTRB(16.0, 0, 16.0, 16.0),
                    children: [
                      if (donations.isNotEmpty) ...[
                        _buildSectionTitle('🌼 Donations'),
                        ...donations.map((data) => _buildTransactionTile(data)).toList(),
                        SizedBox(height: 10),
                      ],
                      if (purchases.isNotEmpty) ...[
                        _buildSectionTitle('🛒 Sprout Purchases'),
                        ...purchases.map((data) => _buildTransactionTile(data)).toList(),
                      ],
                    ],
                  );
                },
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(20.0, 10.0, 20.0, 20.0),
              child: Card(
                color: Colors.green.shade50.withOpacity(0.8),
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
                elevation: 2,
                child: Padding(
                  padding: const EdgeInsets.all(12.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "🌿 Tips for Growing Smart Savers:",
                        style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.green.shade700),
                      ),
                      SizedBox(height: 8),
                      Text(
                        "Start with simple ideas. Use this app like a garden—plant seeds (money), water it (save), and watch it grow! Encourage kids to set fun goals, track spending, and give back by donating. Lead with your own habits—they’ll follow like sunflowers to the sun!",
                        style: TextStyle(fontSize: 15, color: Colors.black87, height: 1.4),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildSectionTitle(String title) {
    return Padding(
      padding: EdgeInsets.symmetric(vertical: 10.0, horizontal: 16.0),
      child: Text(
        title,
        style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.green.shade400),
      ),
    );
  }

  Widget _buildTransactionTile(Map<String, dynamic> data) {
    String dateString = "Date unavailable";
    if (data['timestamp'] != null && data['timestamp'] is Timestamp) {
      try {
        dateString = (data['timestamp'] as Timestamp).toDate().toString().substring(0, 16);
      } catch (e) {}
    }

    num? transactionAmount = data['amount'] as num?;
    String formattedAmount = transactionAmount?.toStringAsFixed(2) ?? 'N/A';

    return Card(
      color: Colors.white.withOpacity(0.9),
      margin: EdgeInsets.symmetric(vertical: 8, horizontal: 8),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
      child: ListTile(
        contentPadding: EdgeInsets.all(12),
        title: Text(
          '${data['name'] ?? 'Unknown Item'}',
          style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.green.shade600),
        ),
        subtitle: Text(
          'Amount: ₹$formattedAmount',
          style: TextStyle(fontSize: 18, color: Colors.black87),
        ),
        trailing: Text(
          dateString,
          style: TextStyle(fontSize: 14, color: Colors.grey.shade700),
        ),
      ),
    );
  }
}
