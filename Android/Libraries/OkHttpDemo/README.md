- http://www.ymapk.com/article-250-1.html(ת���Դ���)
- [��������](https://square.github.io/okhttp/)
- [OkHttp Wiki �ĵ�](https://github.com/square/okhttp/wiki/Calls)

## ���

OkHttp ��һ�����ɵ���������⣬�����������ԣ�

- ֧�� http2, ��һ̨����������������ͬһ�� socket
- �������ӳأ�֧�����Ӹ��ã������ӳ٣���� HTTP2 �����ã�
- ֧��͸���� gzip ѹ����Ӧ��
- ͨ����������ظ�������
- ����ʧ��ʱ�Զ��������������� ip���Զ��ض���



## Android Studio ���� OkHttp3

������ Android Studio �� gradle �н������µ����ã�
```
implementation("com.squareup.okhttp3:okhttp:3.10.0")
```
�������Ȩ��
```
<uses-permission android:name="android.permission.INTERNET"/>
```
## ����ʹ��

- **OkHttp �� get ����**

OkHttp Ĭ���� Get ����
```
private void runSynGet(String url) throws IOException {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url(url)
            .build();
    // Java 7 try-with-resources �����Զ��ر���Դ
    try(Response response = client.newCall(request).execute()) {
        Log.i(TAG, "runSynGet " + response.body().string());
    }
}
```

`client.newCall(request).execute()` �Ǹ�ͬ���ķ���, �ڵ��������߳���ִ�У����Բ���ֱ���� UI �߳���ʹ��������Ҫ�½����̡߳�

OkHttpClient ͬ��֧���첽�����󷽷� `client.newCall(request).enqueue(new  Callback() ...)`  ���� enqueue �������Ҵ���һ���ص��ӿڵ�ʵ�����������£�

```
private void runAsyncGet(String url) throws  IOException {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url(url)
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String json = response.body().string();
            Log.d(TAG, "runAsyncGet" + json);
        }
    });
}
```

����������첽����ģ����Զ��������̣߳������ǲ���Ҫ�����ٸ�������һ�����̡߳�


- **Post �ύ Json ����**

```
// POST �ύ JSON ����
public static final MediaType JSON
        = MediaType.parse("application/json; charset=utf-8");

private void postJson(String url, String json) throws IOException {
    OkHttpClient client = new OkHttpClient();
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
            .url(url)
            .post(body)
            .build();
    try (Response response = client.newCall(request).execute()) {
        Log.d(TAG, "postJson : " + response.body().string());
    }
}
```

> [����MediaType����ϸ����](https://www.jianshu.com/p/4721d7b5e780)


- **Post �ύ��ֵ��**���ܶ�ʱ��������Ҫͨ�� post �Ѽ�ֵ�Դ���������

```
private void postPair(String url) throws IOException {
    OkHttpClient client = new OkHttpClient();

    RequestBody formBody = new FormBody.Builder()
            .add("name","Ramon")
            .add("occupation","Android")
            .build();

    Request request = new Request.Builder()
            .url(url)
            .post(formBody)
            .build();

    Call call = client.newCall(request);
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String str = response.body().string();
            Log.i(TAG, "postPair" + str);
        }
    });
}
```


- **�첽�ϴ��ļ�**
```
// �����ϴ�����Ϊ�ļ�
public static final MediaType MEDIA_TYPE_MARKDOWN
        = MediaType.parse("text/x-markdown; charset=utf-8");
private void postFile() throws IOException {
    OkHttpClient client = new OkHttpClient();
    File file = new File("/sdcard/demo.txt");
    Request request = new Request.Builder()
            .url("https://api.github.com/markdown/raw")
            .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.i(TAG, " postFile : " + response.body().string());
        }
    });
}
```
��Ӷ�дȨ��
```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

- **��ȡ��Ӧͷ**
```
// ��ȡ��Ӧͷ
private void getRespoonseHeader() throws IOException {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("https://api.github.com/repos/square/okhttp/issues")
            .header("User-Agent", "OkHttp Headers.java")
            .addHeader("Accept", "application/json; q=0.5")
            .addHeader("Accept", "application/vnd.github.v3+json")
            .build();
    Response response = client.newCall(request).execute();
    if(!response.isSuccessful())
        throw new IOException("Unexpected code " + response);
    Log.d(TAG, "Server: " + response.header("Server"));
    Log.d(TAG, "Date: " + response.header("Date"));
    Log.d(TAG, "Vary: " + response.headers("Vary"));
}
```

��ȡ���
```
D/OKHttpActivityTag: Server: GitHub.com
D/OKHttpActivityTag: Date: Sun, 31 Mar 2019 08:41:08 GMT
D/OKHttpActivityTag: Vary: [Accept, Accept-Encoding]
```

- **Post ��ʽ�ύ String**

ʹ�� HTTP post ��ʽ�ύһ�� String ���͵� markdown �ĵ��� web ������ Html ��ʽ��Ⱦ Markdown.
```
private void postString() throws IOException {
    OkHttpClient client = new OkHttpClient();
    String postBody = ""
            + "----\n"
            + "* number one\n"
            + "* number two\n";
    Request request = new Request.Builder()
            .url("https://api.github.com/markdown/raw")
            .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.d(TAG, "postString" + response.body().string());
        }
    });
}
```
���н����
```
D/OKHttpActivityTag: postString<hr>
                     <ul>
                     <li>number one</li
                     <li>number two</li
                     </ul>
```

- **Post ��ʽ�ύ��**

�����ķ�ʽ POST �ύ�����壬��������������д�����������ʹ�õ��� Okio �� BufferedSink��
```
private void postStream() throws IOException {
    OkHttpClient client = new OkHttpClient();
    RequestBody requestBody = new RequestBody() {
        @Override
        public MediaType contentType() {
            return MEDIA_TYPE_MARKDOWN;
        }

        @Override
        public void writeTo(BufferedSink sink) throws IOException {
            sink.writeUtf8("Numbers\n");
            sink.writeUtf8("------\n");
            for (int i = 2; i < 100; i++) {
                sink.writeUtf8(String.format("* %s = %s\n",i, factor(i)));
            }
        }

        // �����ֽ�
        private String factor(int n) {
            for (int i = 2; i < n; i++) {
                int x = n /i;
                if (x * i == n) return factor(x) + " X " + i;
            }
            return Integer.toString(n);
        }
    };

    Request request = new Request.Builder()
            .url("https://api.github.com/markdown/raw")
            .post(requestBody)
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.d(TAG, "postStream" + response.body().string());
        }
    });
}
```

- **POST ��ʽ�ύ��**

```
private void postForm() throws IOException {
    OkHttpClient client = new OkHttpClient();
    RequestBody formBody = new FormBody.Builder()
            .add("search", "Jurassic Park")
            .build();

    Request request = new Request.Builder()
            .url("https://en.wikipedia.org/w/index.php")
            .post(formBody)
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.i(TAG, " postForm : " + response.body().string());
        }
    });
}
```

- **Post ��ʽ�ύ�ֿ�����**

MultipartBody ���Թ������ӵ������壬�����������ÿ�鶼��һ�������壬���Զ����Լ�������ͷ����Щ����ͷ�������������������

```
// post �ύ�ֿ�����MultipartBody ʵ��ͬʱ�ϴ��ļ��Ͳ���
private static final String IMGUR_CLIENT_ID = "...";
private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
private void postMultipartBody() throws IOException {
    OkHttpClient client = new OkHttpClient();
    // Use the imgur image upload API as documented at https://api.imgur.com/endpoints/image
    MultipartBody body = new MultipartBody.Builder("AaBO3x")
            .setType(MultipartBody.FORM)
            .addPart(Headers.of("Content-Disposition", "form-data; name=\"title\""),
                    RequestBody.create(null,"Square Logo"))
            .addPart(Headers.of("Content-Disposition", "form-data; name=\"image\""),
                    RequestBody.create(MEDIA_TYPE_PNG, new File("website/static/logo-square.png")))
            .build();
    Request request = new Request.Builder()
            .header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
            .url("https://api.imgur.com/3/image")
            .post(body)
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.i(TAG, " postMultipartBody : " + response.body().string());
        }
    });
}
```

- **��Ӧ����**

Ϊ��ʵ����Ӧ���棬����Ҫ�������¼��㣺

- 1.������Ҫһ�����Զ�д�Ļ���Ŀ¼�������û����С(ע���������Ŀ¼Ӧ����˽�еģ������εĳ����ܷ���)
- 2.һ������Ŀ¼����ӵ�ж��������ʡ����������ֻ��Ҫ����һ�� `new OkHttpClient()`, �ڵ�һ�ε���ʱ���úû��棬Ȼ�������ط������������ʵ�����ɡ���Ȼ��δ��� `HttpClient` ���ܻᵼ�»��ң�Ӧ�ñ�����
- 3.������ͷ������ HTTP ��Ӧ���� `Cache-Control: max-stale=3600` OkHttp�����֧�֡���ķ���ͨ����Ӧͷȷ����Ӧ����೤ʱ�䣬����ʹ��`Cache-Control: max-age=9600`

```
// ��Ӧ����
public void cache() throws IOException {
    int cacheSize = 10 * 1024 * 1024; // 10 MB
    Cache cache = new Cache(getCacheDir(), cacheSize);
    OkHttpClient client = new OkHttpClient.Builder()
            .cache(cache)
            .build();
    Request request = new Request.Builder()
            .url("http://publicobject.com/helloworld.txt")
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.i(TAG, "response cache response " + response.cacheResponse());
            Log.i(TAG, "response network response " + response.networkResponse());
        }
    });
}
```

- **��ʱ**

û����Ӧʱʹ�ó�ʱ���� call��OkHttp ֧��**���ӡ���ȡ��д�볬ʱ**��

```
private void configTimeouts() throws IOException {
    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build();

    Request request = new Request.Builder()
            .url("http://httpbin.org/delay/2") // This URL is served with a 2 second delay.
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Log.d(TAG, "Response : " + response);
        }
    });
}
```

#### ����������

- **����1**`java.net.ProtocolException: Expected ':status' header not present`

������������� Okhttp ���汾 3.10.0 ����ˡ�