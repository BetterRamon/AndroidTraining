- http://hukai.me/android-training-course-in-chinese/basics/data-storage/index.html

## SharedPreference

SharedPreference ���ڱ����ֵ�ԡ�

> **ע��** android7.0 �� `SharedPreferences` ���� `Context.MODE_WORLD_READABLE` �� `Context.MODE_WORLD_WRITEABLE`���ᴥ�� `SecurityException` �쳣���Ѿ����ܿ�Ӧ�÷��ʡ�

#### ����preference�ļ�

- ����һ��`getSharedPreferences()` �������Ҫʹ�����ֶ����� preference �ļ��������ʹ�����������

��һ������Ϊ�ļ������ڶ�������Ϊ����ģʽ��

```
context.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
```
- ��������`getPreferences()` �����ֻ��Ҫһ�� preference �ļ��������ʹ�������������������ṩһ�����ڵ�ǰ Activity �� preference �ļ�������Ҫ���ṩ���֡�

```
getActivity().getPreferences(Context.MODE_PRIVATE);
```

#### ��Preferenceдֵ
```
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putInt(getString(R.string.saved_high_score), newHighScore);
editor.commit();
```

#### ��ȡPreference
```
SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
int defaultValue = getResources().getInteger(R.string.saved_high_score_default);
long highScore = sharedPref.getInt(getString(R.string.saved_high_score), defaultValue);
```

**preference�ļ�·��Ϊ��data/data/your package name/shared_prefs**

## �����ļ�

�ڲ��洢��ָϵͳ�Ĵ洢�ռ䣬û��root�Ƿ��ʲ����ģ����� sharedPreferenced ���� database ���Ǳ�����������ġ��ⲿ�洢��ָ�ֻ��Դ��Ĵ洢����16G��32G��64G��������Sdcard�Ĵ洢��

|internal storage| External storage
|-|:-:|
|���ǿ��õ� | �����ǿ���ʹ�ã���Ϊ�����ܱ��Ƴ���
|ֻ�����Ӧ�ó�����Է������ﱣ����ļ���|������ world-readable��������������ļ��᲻�ܿ��Ƶı��ⲿ��ȡ��
|��ж�����Ӧ�ó���ʱ��Androidϵͳ���Ƴ��ڲ��洢���������app���ļ���|����ж�����Ӧ�ó����ʱ��ϵͳֻ���Ƴ���ʹ��getExternalFilesDir()����������ļ���
|����㲻������Ӧ�ó����������ļ���ʹ���ڲ��洢����õġ�|������������Ӧ�ù����ļ������ڵ����Ϸ�����Щ�ļ�����ôʹ���ⲿ�洢����õġ�

**ע�⣺�� Android 7.0��API����24��֮ǰ������ͨ���ſ��ļ�ϵͳȨ��ʹ����Ӧ�ó�����Է����ڲ��ļ���7.0�����������������ϣ��ʹ˽���ļ������ݿ��Ա�����Ӧ�ó�����ʣ�����Ӧ�ó��������Ҫʹ�� `FileProvider`**

> ��ʾ��Ĭ������£�Ӧ�ó���װ���ڲ��洢�ϣ��������� AndroidManifest ��ָ�� `android��installLocation` ���ԣ��Ա㽫Ӧ�ó���װ���ⲿ�洢��

- ����Ȩ��

�����ļ����ڲ��洢��ʱ���㲻��Ҫ�κ�Ȩ�ޣ����Ӧ�ó�����Ȩ�޷��������ڲ��洢Ŀ¼�����浽�ⲿ�洢ʱ����Ҫ����ⲿ�洢��дȨ�ޡ�
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

- �����ļ����ڲ��洢

���ļ����浽�ڲ��洢��ʱ������ͨ�������������ַ���֮һ��ȡ��Ӧ��Ŀ¼��Ϊ�ļ���

1. `getFilesDir()` ����һ����ʾ�����ڲ�Ŀ¼���ļ����ļ�·��Ϊ�� `/data/user/0/����/files/`

2. `getCacheDir()` ���ش���Ӧ�ó������ʱ�����ļ����ڲ�Ŀ¼���ļ��� ȷ���ڲ�����Ҫʱɾ���ļ������ϵͳ��ʼ����,�ڴ洢�ռ䲻��ʱ������ܻ���û�о���������ɾ�������ļ����ļ�·��Ϊ: `/data/user/0/����/cache/`

����Щ�ļ�Ŀ¼�´���һ���µ��ļ��������ʹ�� `File()` ���췽����ʹ��������������֮һ�����ڲ��洢�ļ�Ŀ¼������

```
File file = new File(context.getFilesDir(), filename);
```

���ߣ������Ե��� `openFileOutput()` ��ȡд���ڲ�Ŀ¼�е��ļ��� `FileOutputStream`�����磬�����ǽ��ı�д���ļ��ķ�����д���·��Ϊ�� `/data/user/0/����/files`

```
String filename = "myfile";
String string = "Hello world!";
FileOutputStream outputStream;
try {
    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
    outputStream.write(string.getBytes());
    outputStream.close();
} catch (Exception e) {
    e.printStackTrace();
}
```

���ߣ��������Ҫ����һЩ�ļ�����Ӧ��ʹ�� `createTempFile()`��

���磬���·����� URL ����ȡ�ļ���������Ӧ�ó�����ڲ�����Ŀ¼�д���һ������Ϊ�����Ƶ��ļ����ļ�·��Ϊ��`/data/user/0/����/cache/`

```
public File getTempFile(Context context, String url) {
    File file;
    try {
        String fileName = Uri.parse(url).getLastPathSegment();
        /*����1��ǰ׺
        ����2�� ��׺
        ����3����ָ��Ŀ¼�´���
        */
        file = File.createTempFile(fileName, null, context.getCacheDir());
    } catch (IOException e) {
        // Error while creating file
    }
    return file;
}
```

- �����ļ����ⲿ�洢

��Ϊ�ⲿ�洢���ܲ����ã���Ҫ�ڷ��ʸþ�֮ǰ��֤�þ��Ƿ���á�ͨ������ `getExternalStorageState()` ����ѯ�ⲿ�洢״̬�� ������ص�״̬���� `MEDIA_MOUNTED`������Զ�ȡ��д���ļ���

```
/* Checks if external storage is available for read and write */
public boolean isExternalStorageWritable() {
    String state = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(state)) {
        return true;
    }
    return false;
}

/* Checks if external storage is available to at least read */
public boolean isExternalStorageReadable() {
    String state = Environment.getExternalStorageState();
    if (Environment.MEDIA_MOUNTED.equals(state) ||
        Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
        return true;
    }
    return false;
}
```

- �ⲿ�洢�������͵��ļ�

**�����ļ�**: �ṩ������Ӧ�ó�����û����ļ��� ���û�ж������Ӧ�ó���ʱ����Щ�ļ�Ӧ����Ȼ�ɹ��û�ʹ�á����磬����Ӧ�ó���������������ص��ļ��������Ƭ��

Ҫ�������ļ��������ⲿ�洢���ϣ�ʹ�� `getExternalStoragePublicDirectory()` ������ȡ��ʾ�ⲿ�洢����ӦĿ¼���ļ��� �÷���ʹ��һ��������ָ��Ҫ������ļ����ͣ��� `DIRECTORY_MUSIC` �� `DIRECTORY_PICTURES`�������磺


```
public File getAlbumStorageDir(String albumName) {
    // Get the directory for the user's public pictures directory.
    File file = new File(Environment.getExternalStoragePublicDirectory(
    Environment.DIRECTORY_PICTURES), albumName);
    if (!file.mkdirs()) {
        Log.e(LOG_TAG, "Directory not created");
    }
    return file;
}
```

**˽���ļ�**: �ļ���������Ӧ�ó������û�ж��Ӧ�ó���ʱ��ɾ���� ��Ȼ��Щ�ļ��ڼ����Ͽ����û�������Ӧ�ó�����ʣ���Ϊ�������ⲿ�洢�ϣ���������ʵ���ϲ�ΪӦ�ó�������û��ṩ��ֵ���ļ������磬����Ӧ�ó������ʱý���ļ����ص�������Դ��

Ҫ����Ӧ�ó����˽�е��ļ����ⲿ�洢�ϣ�ͨ������ `getExternalFilesDir()` ������һ��������ָʾ����Ҫ��Ŀ¼�����͡����磬Ϊ������ᴴ��һ��Ŀ¼��

```
public File getAlbumStorageDir(Context context, String albumName) {
    // Get the directory for the app's private pictures directory.
    File file = new File(context.getExternalFilesDir(
    Environment.DIRECTORY_PICTURES), albumName);
    if (!file.mkdirs()) {
        Log.e(LOG_TAG, "Directory not created");
    }
    return file;
}
```

> ���� `getExternalFilesDir()` ������ `null`��������Ӧ�ó������ⲿ�洢�ϵ�ר��Ŀ¼�ĸ�Ŀ¼��

- ���ÿռ����ļ�ɾ��

����ͨ������ `getFreeSpace()` �� `getTotalSpace()` ��ȷ���Ƿ����㹻�Ŀռ���ö����ᵼ�� IOException��

һ��ɾ���ļ�

```
// ɾ���ļ�
myFile.delete();
```

����ļ��������ڲ��洢���ϣ�����ͨ������ `Context` �� `deleteFile() `���ļ�������ɾ���ļ�

```
myContext.deleteFile(fileName);
```
## �������ݵ����ݿ�

- �������ǵ����ݿ�ı���ֶ�
```
public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}
    /* ͨ��ʵ��BaseColumns�ӿڣ������ڲ�����Լ̳�һ����Ϊ_ID�������ֶ�*/
    public static class FeedEntry implements BaseColumns {
    public static final String TABLE_NAME = "entry";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
```

- ������ɾ�����һЩ�������

```
private static final String SQL_CREATE_ENTRIES =
    "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
        FeedEntry._ID + " INTEGER PRIMARY KEY," +
        FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
        FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
```

- ʹ�� SQL Helper �������ݿ�

```
public class FeedReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";
    
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    /*onCreate �������ڵ���getReadableDatabase����WriteableDatabaseʱ�������ݿⲻ����ʱ�Żᱻ���ã�
    ���ݿ�����Ѿ������򲻻���á�*/
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES);
    }
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        /*�Ƚϴֱ��ķ�����ɾ�����ݱ�Ȼ����� onCreate ���´�����������ʹ��*/
        db.execSQL(FeedReaderContract.SQL_DELETE_ENTRIES);
        onCreate(db);
        /*
        * �������ݿ�����ʵ����ÿһ�����ݿ�汾�����Ӧһ���汾�ţ���ָ�������ݿ�汾�Ŵ��ڵ�ǰ�İ汾
        * �ŵ�ʱ�򣬾ͻ���뵽 onUpgrade() ������ȥִ�и��²�����������ҪΪÿһ���汾�Ÿ��������Ըı�����ݣ�Ȼ����
        * onUpgrade ������ִ�и��²���
        *
        */
        /*ע��һ��ϸ�ڣ���������û��дbreak��Ϊ�˿�汾����ʱ������ִ��*/
        /*switch (oldVersion) {
        case 1:
        //ִ�а汾1�����ݿ����
        db.execSQL(sql);
        case 2:
        //ִ�а汾2�����ݿ����
        db.execSQL(sql);
        default:
        }*/
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
```

- Ҫ�������ݿ⣬��Ҫʵ���� `SQLiteOpenHelper` ������

```
FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getContext());
```

- ��������

ͨ���� `ContentValues` ���󴫵ݸ� `insert()` ���������ݲ��뵽���ݿ��У�

```
// Gets the data repository in write mode
SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
ContentValues values = new ContentValues();
values.put(FeedEntry.COLUMN_NAME_TITLE, title);
values.put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);

// Insert the new row, returning the primary key value of the new row
long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
```

`insert()` �ĵ�һ������ָʾ������

�ڶ����������߿���� `ContentValues` Ϊ�յ�����£�������û�з����κ�ֵ������ʲô�� ���ָ���е����ƣ���ܽ�����һ�в������е�ֵ����Ϊ null�����ָ�� null������˴���ʾ����һ������û��ֵʱ���������һ�С�

- ��ȡ����

Ҫ�����ݿ��ж�ȡ����ʹ�� `query()` ��������������ѡ���������������,��ѯ�Ľ������ Cursor �����з��ظ�����

```
SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
String[] projection = {
    FeedEntry._ID,
    FeedEntry.COLUMN_NAME_TITLE,
    FeedEntry.COLUMN_NAME_SUBTITLE
};

// Filter results WHERE "title" = 'My Title'
String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
String[] selectionArgs = { "My Title" };

// How you want the results sorted in the resulting Cursor
String sortOrder = FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

Cursor cursor = db.query(
    FeedEntry.TABLE_NAME, // The table to query
    projection, // ��Ҫ���ص���
    selection, // Where �����е���
    selectionArgs, // Where �������е�ֵ
    null, // don't group the rows
    null, // don't filter by row groups
    sortOrder // The sort order
);
```

Ҫ�鿴����е�һ�У���ʹ������һ�� `Cursor` �ƶ�������������ʼ���ڿ�ʼ��ȡֵ֮ǰ���ø÷����� ���ڹ���λ��-1��ʼ�����Ե��� `moveToNext()` ������ȡλ�á����ڽ���ĵ�һ����Ŀ�ϣ������ع���Ƿ��Ѿ�����������е����һ����Ŀ������ÿһ�У�������ͨ������һ��`Cursor get` ��������ȡ�е�ֵ������ `getString()` �� `getLong()` ������ÿ�� get �����������봫�������е�����λ�ã�������ͨ������ `getColumnIndex()` �� `getColumnIndexOrThrow()` ��ȡ������λ�á�����ɵ������֮�󣬵��ù���ϵ� `close()` ���ͷ�����Դ������

```
List itemIds = new ArrayList<>();
while(cursor.moveToNext()) {
    long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(FeedEntry._ID);
    itemIds.add(itemId);
}
cursor.close();
```

- ɾ������

Ҫ�ӱ���ɾ���У�����Ҫ�ṩ��ʶ�е�ѡ��������
```
// Define 'where' part of query.
String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";

// Specify arguments in placeholder order.
String[] selectionArgs = { "MyTitle" };

// Issue SQL statement.
db.delete(FeedEntry.TABLE_NAME, selection, selectionArgs);
```

- ��������

���±� `insert()` ������ֵ�﷨�� `delete()` ���﷨���ϡ�

```
SQLiteDatabase db = mDbHelper.getWritableDatabase();

// New value for one column
ContentValues values = new ContentValues();
values.put(FeedEntry.COLUMN_NAME_TITLE, title);

// Which row to update, based on the title
String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";

String[] selectionArgs = { "MyTitle" };

int count = db.update(
    FeedReaderDbHelper.FeedEntry.TABLE_NAME,
    values,
    selection,
    selectionArgs);
```

- ���ݿ��������

```
SQLiteDatabase db = fdHelper.getWritableDatabase();
db.beginTransaction();//��������
try{
    if(true){
        //�ֶ��׳�һ���쳣��������ʧ�ܣ�ע�͵���һ��������ִ�гɹ�
        throw new NullPointerException();
    }
    ContentValues values = new ContentValues();
    values.put(FeedEntry.COLUMN_NAME_TITLE,title.getText().toString());
    
    values.put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle.getText().toString());
    
    db.insert(FeedEntry.TABLE_NAME, null, values);
    db.setTransactionSuccessful(); //����ִ�гɹ�
}catch(Exception e){
    e.printStackTrace();
}finally{
    db.endTransaction();//��������
}
```

- �־����ݿ�����

���� `getWritableDatabase()` �� `getReadableDatabase()` �����ݿ�ر�ʱ���óɱ��߰�����Ӧ�ý����ݿ����Ӵ򿪡�ͨ����`onDestroy()` �еĹر����ݿ�����ѵġ�

```
@Override
protected void onDestroy() {
    mDbHelper.close();
    super.onDestroy();
}
```

- ���ǿ���ֱ�ӵ���ʹ��SQL���������ݿ�

```
SQLiteDatabase db = openOrCreateDatabase(DdName, MODE_PRIVATE, null);
db.execSQL( sql)
db.rawQuery(sql);
```

����Դ�룺[SavingData](./SavingData)

> �������ַ������ǲ�ͨ�� SQLiteOpenHelper ��� API ���������ݿ⣬����ʹ�� SQL ��������һ�㲻�Ƽ�ʹ�á�