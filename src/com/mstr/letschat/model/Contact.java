package com.mstr.letschat.model;

import com.mstr.letschat.databases.ChatContract.ContactRequestTable;
import com.mstr.letschat.databases.ChatContract.ContactTable;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable{
	private String jid;
	private String nickname;
	
	public Contact() {}
	
	public Contact(String jid, String nickname) {
		this.nickname = nickname;
		this.jid = jid;
	}
	
	public Contact(Parcel source) {
		jid = source.readString();
		nickname = source.readString();
	}
	
	public static ContentValues newContentValues(String jid, String nickname) {
		ContentValues values = new ContentValues();
		values.put(ContactTable.COLUMN_NAME_JID, jid);
		values.put(ContactTable.COLUMN_NAME_NICKNAME, nickname);
		
		return values;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String name) {
		this.nickname = name;
	}
	
	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}
	
	@Override
	public String toString() {
		return nickname;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(jid);
		dest.writeString(nickname);
	}
	
	public static final Parcelable.Creator<Contact> CREATOR = new Creator<Contact>() {

		@Override
		public Contact createFromParcel(Parcel source) {
			return new Contact(source);
		}

		@Override
		public Contact[] newArray(int size) {
			return new Contact[size];
		}
		
	};
}