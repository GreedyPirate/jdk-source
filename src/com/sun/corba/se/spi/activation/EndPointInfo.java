package com.sun.corba.se.spi.activation;


/**
* com/sun/corba/se/spi/activation/EndPointInfo.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u161/10277/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Tuesday, December 19, 2017 4:23:58 PM PST
*/

public final class EndPointInfo implements org.omg.CORBA.portable.IDLEntity
{
  public String endpointType = null;
  public int port = (int)0;

  public EndPointInfo ()
  {
  } // ctor

  public EndPointInfo (String _endpointType, int _port)
  {
    endpointType = _endpointType;
    port = _port;
  } // ctor

} // class EndPointInfo
