/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\Eclipse\\AndroidStudy\\UI\\src\\com\\example\\ui\\service\\ICat.aidl
 */
package com.example.ui.service;
public interface ICat extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.ui.service.ICat
{
private static final java.lang.String DESCRIPTOR = "com.example.ui.service.ICat";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.ui.service.ICat interface,
 * generating a proxy if needed.
 */
public static com.example.ui.service.ICat asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.ui.service.ICat))) {
return ((com.example.ui.service.ICat)iin);
}
return new com.example.ui.service.ICat.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getColor:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getColor();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.ui.service.ICat
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getColor() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getColor, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getColor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.lang.String getColor() throws android.os.RemoteException;
}
