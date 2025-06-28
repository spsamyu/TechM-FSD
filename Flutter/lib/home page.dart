import 'package:flutter/material.dart';
import 'parent_login.dart';
import 'kids_page.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Positioned.fill(
            child: Container(
              decoration: BoxDecoration(
                image: DecorationImage(
                  image: AssetImage('assets/home_bg.png'),
                  fit: BoxFit.cover,
                ),
              ),
            ),
          ),
          SafeArea(
            child: Column(
              children: [
                Spacer(),
                // Garden-themed mascot image (replace piggy.png with sprout.png)
                Image.asset('https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.bbc.co.uk%2Fhamptoncourt%2Ffeatures%2F2011%2Fshow-gardens%2Fvirtual-reality-garden-bruce-waldock.shtml&psig=AOvVaw1thVtNtXUALtYLZvIrI70N&ust=1751132738744000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCKCc8_qTko4DFQAAAAAdAAAAABAE', height: 300), 
                
                SizedBox(height: 20),
                Text(
                  'SproutSave',
                  style: TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    letterSpacing: 1.2,
                  ),
                ),
                SizedBox(height: 40),
                
                // Navigation Buttons
                MenuButton(
                  icon: Icons.person,
                  text: 'Parent',
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => ParentLoginPage()),
                    );
                  },
                  color: Colors.green.shade700,
                ),
                MenuButton(
                  icon: Icons.child_care,
                  text: 'Kids',
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => KidsPage()),
                    );
                  },
                  color: Colors.lightGreen.shade400,
                ),
                MenuButton(
                  icon: Icons.info,
                  text: 'About',
                  onTap: () {
                    showAboutDialog(
                      context: context,
                      applicationName: 'SproutSave',
                      applicationVersion: '1.0',
                      children: [
                        Text('SproutSave is a fun virtual garden to help kids learn about saving, growing goals, and financial habits.'),
                      ],
                    );
                  },
                  color: Colors.teal.shade400,
                ),
                Spacer(),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class MenuButton extends StatelessWidget {
  final IconData icon;
  final String text;
  final VoidCallback onTap;
  final Color color;

  const MenuButton({
    required this.icon,
    required this.text,
    required this.onTap,
    required this.color,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 50),
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(
          padding: EdgeInsets.symmetric(vertical: 15),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(30),
          ),
          backgroundColor: color,
          foregroundColor: Colors.white,
          shadowColor: Colors.black26,
          elevation: 5,
        ),
        onPressed: onTap,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(icon, size: 24),
            SizedBox(width: 10),
            Text(
              text,
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
    );
  }
}
