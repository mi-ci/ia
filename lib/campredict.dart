import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';
import 'dart:math';
import 'dart:async';
import 'package:image_picker/image_picker.dart';
import 'package:permission_handler/permission_handler.dart';
import 'dart:io';
import 'package:http/http.dart' as http;

class CameraPage extends StatefulWidget {
  @override
  _CameraPageState createState() => _CameraPageState();
}

class _CameraPageState extends State<CameraPage> {
  File? _image;
  Image? _processedImage;
  final ImagePicker picker = ImagePicker();
  open() async {
    PermissionStatus status = await Permission.camera.request();
    if (status.isGranted) {
      final XFile? image = await picker.pickImage(source: ImageSource.camera);
      if (image != null) {
        File imageFile = File(image.path);
        setState(() {
          _image = imageFile;
        });
        await uploadImage(imageFile);
      }
    }
  }

  uploadImage(File imageFile) async {
    String apiUrl = 'https://e9ba-1-233-65-186.ngrok-free.app/predict';
    var request = http.MultipartRequest('POST', Uri.parse(apiUrl));
    request.files
        .add(await http.MultipartFile.fromPath('frame', imageFile.path));

    var response = await request.send();

    if (response.statusCode == 200) {
      var responseData = await response.stream.toBytes();
      setState(() {
        _processedImage = Image.memory(responseData);
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Column(
      children: [
        Center(
          child: ElevatedButton(
            onPressed: open,
            child: Text('Open Camera'),
          ),
        ),
        SizedBox(height: 20),
        _processedImage != null ? _processedImage! : Container(),
      ],
    ));
  }
}
