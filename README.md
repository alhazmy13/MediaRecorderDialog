<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/4659608/12700283/c3072022-c7ee-11e5-8862-6b73f90c3066.png" >
</p>
# Media Recorder Dialog
![](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![](https://img.shields.io/badge/Android-CustomView-blue.svg)
![](https://img.shields.io/crates/l/rustc-serialize.svg)
![](https://img.shields.io/badge/version-0.1.2_beta-blue.svg)

------ 
Android has a built in microphone through which you can capture audio and store it , or play it in your phone. There are many ways to do that but with this dialog you can do all thats with only one dialog.

You can report any issue on issues page. **Note: If you speak Arabic, you can submit issues with Arabic language and I will check them. :)**

![mediarecorderdialog](https://cloud.githubusercontent.com/assets/4659608/11994579/303214a0-aa52-11e5-9d91-0e88e6b4da4c.gif)



## Installation
------ 
**Maven**
```xml
<dependency>
<groupId>net.alhazmy13.MediaRecorderDialog</groupId>
<artifactId>libary</artifactId>
<version>0.1.2-beta</version>
</dependency>
```


**Gradle**
```gradle

dependencies {
	compile 'net.alhazmy13.MediaRecorderDialog:libary:0.1.2-beta'
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
            //Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
        }
    })
    .show();

```

### Implement an `OnSaveButtonClickListener`
In order to receive the path of file, you will need to implement the `OnSaveButtonClickListener` interfaces. 
```java
    @Override
    public void onSucceed(String path) {
        //Your Code
    }
    @Override
    public void onFailure() {
        //Your Code
    }
```

### Additional Options
* `setTitle` You can change the title of Dialog 
```java
.setTitle("Recording,,,")
```
* `setMessage` to change the message  
```java
.setMessage("Press the button")
```
* `setOutputFormat` You can change the Output format by passing the format from  `MediaRecorderDialog.OutputFormat`
```java
.setOutputFormat(MediaRecorderDialog.OutputFormat.MPEG_4)
```
* `setAudioEncoder` You can change the  Encoder by passing the value from  `MediaRecorderDialog.AudioEncoder`
```java
.setAudioEncoder(MediaRecorderDialog.AudioEncoder.AAC)
```
### Theme and style
You can theme the dialog by overwriting the color resources in your project.
```xml
    <color name="media_recorder_colorPrimary">#00796B</color>
    <color name="media_recorder_background">#009688</color>
    <color name="media_recorder_bar">#80CBC4</color>
```
### Credits 
* [Gota Library](https://github.com/alhazmy13/Gota) 
* [AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations).
* [Android Ripple Background Library](https://github.com/skyfishjy/android-ripple-background) 


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
    

