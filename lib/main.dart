import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';
import 'dart:math';
import 'dart:async';
import 'package:image_picker/image_picker.dart';
import 'package:permission_handler/permission_handler.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Simple Navigation App',
      home: LoadingScreen(),
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int a = 0;
  int d = 0;
  var random = Random();
  int b = 0;
  var c = '';
  Timer? timer;
  earn() {
    setState(() {
      var r = random.nextInt(9000) + 1000;
      a = a + r;
      b = r;
    });
  }

  buy() {
    setState(() {
      if (a < 100000) {
        c = '금액이 부족합니다';
        timer = Timer(Duration(seconds: 1), () {
          setState(() {
            c = '';
          });
        });
      } else {
        a = a - 100000;
        d = d + 1;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('로아 골드 복제기'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text('보유 골드 : $a'),
          ),
          Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(vertical: 16.0),
              child: Image.asset('assets/images/0.png'), // Add your image here
            ),
          ),
          Center(
              child: Padding(
            padding: const EdgeInsets.only(bottom: 6.0),
            child: ElevatedButton(
              onPressed: earn,
              child: Text('골드 벌기'),
            ),
          )),
          Center(
            child: Padding(
              padding: const EdgeInsets.only(bottom: 66),
              child: Text('$b골드를 획득하셨습니다!'),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text('보유 보석 : $d'),
          ),
          Center(
            child: Padding(
              padding: const EdgeInsets.symmetric(vertical: 16.0),
              child: Image.asset('assets/images/01.jpg'), // Add your image here
            ),
          ),
          Center(
            child: ElevatedButton(
              onPressed: buy,
              child: Text('보석 구매'),
            ),
          ),
          Center(
            child: Padding(
              padding: const EdgeInsets.only(bottom: 6),
              child: Text(c),
            ),
          ),
          Center(
            child: ElevatedButton(
              onPressed: () => {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => CameraPage()))
              },
              child: Text('다음페이지'),
            ),
          )
        ],
      ),
    );
  }
}

class CameraPage extends StatefulWidget {
  @override
  _CameraPageState createState() => _CameraPageState();
}

class _CameraPageState extends State<CameraPage> {
  final ImagePicker picker = ImagePicker();
  open() async {
    PermissionStatus status = await Permission.camera.request();
    if (status.isGranted) {
      final XFile? image = await picker.pickImage(source: ImageSource.camera);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: ElevatedButton(
          onPressed: open,
          child: Text('카메라 열기'),
        ),
      ),
    );
  }
}

class LoadingScreen extends StatefulWidget {
  @override
  _LoadingScreenState createState() => _LoadingScreenState();
}

class _LoadingScreenState extends State<LoadingScreen> {
  Timer? timer;

  @override
  void initState() {
    super.initState();
    a(); // Call the function here to start the timer when the widget is created
  }

  a() {
    timer = Timer(Duration(seconds: 1), () {
      setState(() {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => HomePage()));
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
      child: CircularProgressIndicator(),
    ));
  }
}
