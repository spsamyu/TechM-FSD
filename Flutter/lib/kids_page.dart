import 'package:flutter/material.dart'; 
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:flutter/services.dart';
import 'package:myflutterprj/chores.dart';

class KidsPage extends StatefulWidget {
  @override
  _KidsPageState createState() => _KidsPageState();
}

class _KidsPageState extends State<KidsPage> {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  List<dynamic> _storeItems = [];
  List<dynamic> _charities = [];
  String? _selectedCharity;
  TextEditingController _amountController = TextEditingController();

  @override
  void initState() {
    super.initState();
    fetchStoreItems();
    _loadCharities();
  }

  Future<void> fetchStoreItems() async {
    final response = await http.get(Uri.parse("https://fakestoreapi.com/products"));
    if (response.statusCode == 200) {
      setState(() {
        _storeItems = json.decode(response.body);
      });
    } else {
      throw Exception("Failed to load store items");
    }
  }

  Future<void> _loadCharities() async {
    String data = await rootBundle.loadString('assets/charities.json');
    setState(() {
      _charities = json.decode(data);
    });
  }

  void _buyItem(double growth, double itemPrice) async {
    if (itemPrice > growth) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Not enough growth points 🌱 to buy this item')),
      );
      return;
    }

    await _firestore.collection('garden').doc('child').update({
      'growth': growth - itemPrice,
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text('Purchase successful! 🌱$itemPrice used.')),
    );
  }

  void _showStoreDialog(double growth) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          backgroundColor: Colors.white,
          title: Text('Garden Store', style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
          content: Container(
            width: double.maxFinite,
            height: 450,
            child: _storeItems.isEmpty
                ? Center(child: CircularProgressIndicator())
                : ListView.builder(
                    itemCount: _storeItems.length,
                    itemBuilder: (context, index) {
                      var item = _storeItems[index];
                      return Card(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                          side: BorderSide(color: Colors.green.shade700, width: 2),
                        ),
                        color: Colors.white,
                        elevation: 8,
                        margin: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                        child: Padding(
                          padding: EdgeInsets.all(12),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.center,
                            children: [
                              ClipRRect(
                                borderRadius: BorderRadius.circular(15),
                                child: Image.network(item['image'], width: 100, height: 100, fit: BoxFit.cover),
                              ),
                              SizedBox(height: 10),
                              Text(
                                item['title'],
                                textAlign: TextAlign.center,
                                style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.green.shade700),
                              ),
                              SizedBox(height: 5),
                              Text(
                                "🌱${item['price']}",
                                style: TextStyle(fontSize: 20, color: Colors.green.shade700, fontWeight: FontWeight.bold),
                              ),
                              SizedBox(height: 10),
                              ElevatedButton(
                                onPressed: () => _buyItem(growth, item['price']),
                                style: ElevatedButton.styleFrom(
                                  backgroundColor: Colors.green.shade700,
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(12),
                                  ),
                                  padding: EdgeInsets.symmetric(vertical: 14, horizontal: 30),
                                ),
                                child: Text(
                                  'Grow',
                                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white),
                                ),
                              ),
                            ],
                          ),
                        ),
                      );
                    },
                  ),
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context),
              child: Text('Close', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
            ),
          ],
        );
      },
    );
  }

  void _showDonationDialog(double growth) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          backgroundColor: Colors.white,
          title: Text('Donate Seeds', style: TextStyle(fontSize: 26, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              DropdownButton<String>(
                value: _selectedCharity,
                dropdownColor: Colors.white,
                hint: Text('Choose a Cause', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
                onChanged: (String? newValue) {
                  setState(() {
                    _selectedCharity = newValue;
                  });
                },
                items: _charities.map<DropdownMenuItem<String>>((dynamic charity) {
                  return DropdownMenuItem<String>(
                    value: charity['name'],
                    child: Text(charity['name'], style: TextStyle(fontSize: 18, color: Colors.green.shade700)),
                  );
                }).toList(),
              ),
              SizedBox(height: 20),
              TextField(
                controller: _amountController,
                keyboardType: TextInputType.number,
                style: TextStyle(color: Colors.green.shade700, fontSize: 18),
                decoration: InputDecoration(
                  labelText: 'Seed Amount',
                  labelStyle: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.green.shade700),
                  enabledBorder: OutlineInputBorder(
                    borderSide: BorderSide(color: Colors.green.shade700),
                    borderRadius: BorderRadius.circular(10),
                  ),
                  focusedBorder: OutlineInputBorder(
                    borderSide: BorderSide(color: Colors.green.shade700, width: 2),
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context),
              child: Text('Cancel', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.green.shade700)),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context);
                _donate(growth);
              },
              child: Text('Donate', style: TextStyle(color: Colors.white)),
              style: ElevatedButton.styleFrom(
                padding: EdgeInsets.symmetric(vertical: 20, horizontal: 40),
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(30),
                ),
                backgroundColor: Colors.green.shade700,
              ),
            ),
          ],
        );
      },
    );
  }

  void _donate(double growth) {
    double donationAmount = double.tryParse(_amountController.text) ?? 0.0;
    if (_selectedCharity == null || donationAmount <= 0) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Please choose a cause and enter a valid amount')),
      );
      return;
    }

    if (donationAmount > growth) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Not enough seeds 🌱 to donate')),
      );
      return;
    }

    _firestore.collection('garden').doc('child').update({
      'growth': growth - donationAmount,
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text('You donated 🌱$donationAmount to $_selectedCharity')),
    );

    _amountController.clear();
    setState(() {
      _selectedCharity = null;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sprout Garden',
            style: TextStyle(fontSize: 26, fontWeight: FontWeight.bold, color: Colors.white)),
        backgroundColor: Colors.green.shade700,
      ),
      body: Stack(
        children: [
          Positioned.fill(
            child: Image.asset(
              'assets/garden_bg.png',
              fit: BoxFit.cover,
            ),
          ),
          StreamBuilder<DocumentSnapshot>(
            stream: _firestore.collection('garden').doc('child').snapshots(),
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                return Center(child: CircularProgressIndicator());
              }
              if (!snapshot.hasData || !snapshot.data!.exists) {
                return Center(child: Text('No growth yet.', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)));
              }
              var data = snapshot.data!;
              double growth = data['growth'] ?? 0.0;

              return Column(
                mainAxisAlignment: MainAxisAlignment.start,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  SizedBox(height: 80),
                  Padding(
                    padding: const EdgeInsets.symmetric(vertical: 16.0, horizontal: 8.0),
                    child: Center(
                      child: Text(
                        'Total Seeds Collected:\n🌱${growth.toStringAsFixed(2)}',
                        textAlign: TextAlign.center,
                        style: TextStyle(
                          fontSize: 22,
                          fontWeight: FontWeight.bold,
                          color: Colors.white,
                          fontFamily: 'ComicNeue',
                        ),
                      ),
                    ),
                  ),
                  SizedBox(height: 30),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => ChoresPage()),
                      );
                    },
                    child: Text("Garden Tasks", style: TextStyle(color: Colors.white, fontSize: 20)),
                    style: ElevatedButton.styleFrom(
                      padding: EdgeInsets.symmetric(vertical: 25, horizontal: 60),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(30),
                      ),
                      backgroundColor: Colors.green.shade700,
                    ),
                  ),
                  SizedBox(height: 30),
                  ElevatedButton(
                    onPressed: () => _showDonationDialog(growth),
                    child: Text('Donate Seeds', style: TextStyle(color: Colors.white, fontSize: 20)),
                    style: ElevatedButton.styleFrom(
                      padding: EdgeInsets.symmetric(vertical: 25, horizontal: 60),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(30),
                      ),
                      backgroundColor: Colors.green.shade700,
                    ),
                  ),
                  SizedBox(height: 30),
                  ElevatedButton(
                    onPressed: () => _showStoreDialog(growth),
                    child: Text('Garden Store', style: TextStyle(color: Colors.white, fontSize: 20)),
                    style: ElevatedButton.styleFrom(
                      padding: EdgeInsets.symmetric(vertical: 25, horizontal: 60),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(30),
                      ),
                      backgroundColor: Colors.green.shade700,
                    ),
                  ),
                ],
              );
            },
          ),
        ],
      ),
    );
  }
}
