public class FirebaeRealtimeDatabase {
   private DatabaseReference databaseReference;

    public FirebaeRealtimeDatabase() {
        databaseReference = FirebaseDatabase.getInstance().getReference("akun");
    }

    public void getData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    UserPojo userPojo = dataSnapshot.getValue(UserPojo.class);

                    //remove
                    databaseReference.removeEventListener(this);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void sendData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                databaseReference.push().setValue(new UserPojo());
                databaseReference.removeEventListener(this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
