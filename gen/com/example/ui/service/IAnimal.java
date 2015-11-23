/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\Eclipse\\AndroidStudy\\UI\\src\\com\\example\\ui\\service\\IAnimal.aidl
 */
package com.example.ui.service;
public interface IAnimal extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.ui.service.IAnimal
{
private static final java.lang.String DESCRIPTOR = "com.example.ui.service.IAnimal";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.ui.service.IAnimal interface,
 * generating a proxy if needed.
 */
public static com.example.ui.service.IAnimal asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.ui.service.IAnimal))) {
return ((com.example.ui.service.IAnimal)iin);
}
return new com.example.ui.service.IAnimal.Stub.Proxy(obj);
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
case TRANSACTION_getDog:
{
data.enforceInterface(DESCRIPTOR);
com.example.ui.service.IDog _result = this.getDog();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getCat:
{
data.enforceInterface(DESCRIPTOR);
com.example.ui.service.ICat _result = this.getCat();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.ui.service.IAnimal
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
@Override public com.example.ui.service.IDog getDog() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.example.ui.service.IDog _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDog, _data, _reply, 0);
_reply.readException();
_result = com.example.ui.service.IDog.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.example.ui.service.ICat getCat() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.example.ui.service.ICat _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCat, _data, _reply, 0);
_reply.readException();
_result = com.example.ui.service.ICat.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getDog = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getCat = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public com.example.ui.service.IDog getDog() throws android.os.RemoteException;
public com.example.ui.service.ICat getCat() throws android.os.RemoteException;
}
