# Media Recorder Dialog
------ 
Media Picker is an Android Libary that lets you to select multiple images, video or voice for Android 4.1 (API 16) +.
You can report any issue on issues page. **Note: If you speak Arabic, you can submit issues with Arabic language and I will check them. :)**


## Installation
------ 
**Maven**
```xml
<dependency>
<groupId>net.alhazmy13.MediaRecorderDialog</groupId>
<artifactId>libary</artifactId>
<version>0.1.1-beta</version>
</dependency>
```


**Gradle**
```gradle

dependencies {
	compile 'net.alhazmy13.MediaRecorderDialog:libary:0.1.1-beta'
}
```

# Usage
------ 
```java

 new MediaRecorderDialog.Builder(MainActivity.this)
                        .setOutputFormat(MediaRecorderDialog.OutputFormat.MPEG_4)
                        .setAudioEncoder(MediaRecorderDialog.AudioEncoder.AAC)
                        .setTitle("Recording,,,")
                        .setMessage("Press the button")
                        .setOnSaveButtonClickListener(new OnSaveButtonClickListener() {
                            @Override
                            public void onSucceed(String path) {
                               // Toast.makeText(MainActivity.this,path,Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure() {
                                //Toast.makeText(MainActivity.this,"onFailure",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();


```


### Additional Options
* `SetExtanion` You can change the extanion of image to `PNG` or `JPG`
```java
imagePicker.setExtension(ImagePicker.PNG);
```
* `setCompressLevel` You can change the quality of image with three different levels `HARD`,`MEDIUM` or `SOFT`
```java
imagePicker.setCompressLevel(ImagePicker.MEDIUM);
```

* `setDirectory` You can pass the storage path, or You can select `ImagePicker.DEFAULT_DIR` to keep the default path.
```java
imagePicker.setDirectory(ImagePicker.DEFAULT_DIR);

//OR

imagePicker.setDirectory(Environment.getExternalStorageDirectory()+"/myFolder");

```
------ 

## Video
------ 
After adding the library, you need to:

1. Implement an `OnVideoSetListener`
2. Create an object from `VideoPicker` 


### Implement an `OnVideoSetListener`
In order to receive the path of video, you will need to implement the `OnVideoSetListener`  interfaces. Typically this will  call camera activity and return the path of video.
```java
 @Override
    public void OnVideoSet(String path) {
        
    }
```

### Create a `VideoPicker`
You will need to create a new instance of `VideoPicker`. Once the instance are configured, you can call `pick()`.
```java
        VideoPicker videoPicker=new VideoPicker(this);
        videoPicker.setOnVideoSetListener(this);
        videoPicker.pick();
```


### Additional Options
* `SetExtanion` You can change the extanion of video to `Mp4`,`3gp` or `mkv`
```java
    videoPicker.setExtension(VideoPicker._MP4);
```
* `setDirectory` You can pass the storage path, or You can select `VideoPicker.DEFAULT_DIR` to keep the default path.
```java
videoPicker.setDirectory(VideoPicker.DEFAULT_DIR);

//OR

videoPicker.setDirectory(Environment.getExternalStorageDirectory()+"/myFolder");

```


## Voice 
------ 
**Comming Soon,,,**

# Comming Fetaures
------ 
* Resize, compress, filter and optimize image.
* Pick/Select Image from Gallery.
* Record video and voice.
* etc...           
```


## License
------ 
    Copyright 2015 alhazmy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    

