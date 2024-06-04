import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Simple Navigation App',
      home: HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  var a = 0;
  final Uri _url = Uri.parse('https://www.google.com');

  Future<void> _launchURL() async {
    if (!await launchUrl(
      _url,
      mode: LaunchMode.externalApplication, // Use external application
    )) {
      throw 'Could not launch $_url';
    }
    a = a + 1;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home Page'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: _launchURL,
          child: Text('Go to Google' + a.toString()),
        ),
      ),
    );
  }
}
