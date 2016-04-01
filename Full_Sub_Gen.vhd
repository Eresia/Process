LIBRARY ieee;
USE ieee.std_logic_1164.all;

entity Full_Sub_Gen IS
Generic(SIZE : positive := 8);
port(
	A,B : IN std_logic_vector(0 TO (SIZE/2)-1);
	Cin : IN std_logic;
	S : OUT std_logic_vector(0 TO (SIZE/2)-1);
	Cout : OUT std_logic
);
end entity;

ARCHITECTURE Behavior OF Full_Sub_Gen IS

	component Full_Sub_2_1
		PORT(
		A,B,Cin : IN std_logic;
		S, Cout : OUT std_logic
	);
	end component;

Signal retenues: std_logic_vector(0 TO (SIZE/2)-1);
BEGIN
	retenues((SIZE/2)-1) <= Cin;
	boucle: for i in (SIZE/2)-1 downto 1 generate
		fa : Full_Sub_2_1 port map(A=>A(i), B=>B(i), Cin=>retenues(i), S=>S(i), Cout=>retenues(i-1));
	end generate boucle;
	fa : Full_Sub_2_1 port map(A=>A(0), B=>B(0), Cin=>retenues(0), S=>S(0), Cout=>Cout);
END Behavior;