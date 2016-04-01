LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY ALU IS
PORT(
	A,B : IN std_logic_vector(0 TO 15);
	Operation: IN std_logic_vector(0 TO 2);
	S: OUT std_logic_vector(0 TO 15);
	Overflow : OUT std_logic
);
END ALU;

ARCHITECTURE Behavior OF ALU IS
Component Full_Adder_Gen IS
	GENERIC(SIZE : positive := 8);
	PORT(
		A,B : IN std_logic_vector(0 TO (SIZE/2)-1);
		Cin : IN std_logic;
		S : OUT std_logic_vector(0 TO (SIZE/2)-1);
		Cout : OUT std_logic
	);
END Component;

Component Full_Sub_Gen IS
	GENERIC(SIZE : positive := 8);
	PORT(
		A,B : IN std_logic_vector(0 TO (SIZE/2)-1);
		Cin : IN std_logic;
		S : OUT std_logic_vector(0 TO (SIZE/2)-1);
		Cout : OUT std_logic
	);
END Component;

Component Mux_ALU IS
	GENERIC(SIZE : positive := 16);
	PORT(
		A,B,C,D,E,F,G,H : IN std_logic_vector(0 TO SIZE-1) := (others => '0');
		Sel: IN std_logic_vector(0 TO 2);
		O : OUT std_logic_vector(0 TO SIZE-1)
	);
END Component;

signal Sadd : std_logic_vector(0 TO 15);
signal Ssub : std_logic_vector(0 TO 15);
signal Cmux : std_logic_vector(0 TO 0);
signal Cadd : std_logic_vector(0 TO 0);
signal Csub : std_logic_vector(0 TO 0);

BEGIN
	add0: Full_Adder_Gen generic map(32) port map(A=>A, B=>B, Cin=>'0', S=>Sadd, Cout=>Cadd(0));
	sub0: Full_Sub_Gen generic map(32) port map(A=>A, B=>B, Cin=>'0', S=>Ssub, Cout=>Csub(0));
	mux0: Mux_ALU generic map(16) port map(A=>Ssub, B=>Sadd, C=>(A and B), D=>(A or B), E=>(not B), Sel=>Operation, O=>S);
	mux1: Mux_ALU generic map(1) port map(A=>Csub, B=>Cadd, C=>"0", D=>"0", E=>"0", Sel=>Operation, O=>CMux);
	Overflow <= CMux(0);
END Behavior;