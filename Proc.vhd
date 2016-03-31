LIBRARY ieee; USE ieee.std_logic_1164.all;
USE ieee.std_logic_signed.all;

ENTITY proc IS
PORT (
	Clock, Run, Reset: IN std_logic;
	DIN: IN std_logic_vector(0 TO 15);
	Done: OUT std_logic;
	Overflow: OUT std_logic;
	B: OUT std_logic_vector(0 TO 15);
	State: OUT Integer;
	OPPrint: OUT std_logic_vector(0 TO 2);
	whichWrite: OUT std_logic_vector(0 TO 7);
	addPrint: OUT std_logic_vector(0 TO 15);
	R0, R1, R2, R3 : OUT std_logic_vector(0 TO 15)
);
END proc;

ARCHITECTURE Behavior OF proc IS

Component Control IS
	PORT(
		OP: IN std_logic_vector(0 TO 8);
		Run, Reset, Clock: IN std_logic;
		Set: OUT std_logic_vector(0 TO 13);
		Sel: OUT std_logic_vector(0 TO 4);
		Done: OUT std_logic;
		State: OUT Integer;
		OPPrint: OUT std_logic_vector(0 TO 2)
	);
END Component;

Component Mux_Proc IS
	PORT(
		Sel: IN std_logic_vector(0 TO 4);
		G: IN std_logic_vector(0 TO 15);
		DIN: IN std_logic_vector(0 TO 15);
		R0: IN std_logic_vector(0 TO 15);
		R1: IN std_logic_vector(0 TO 15);
		R2: IN std_logic_vector(0 TO 15);
		R3: IN std_logic_vector(0 TO 15);
		R4: IN std_logic_vector(0 TO 15);
		R5: IN std_logic_vector(0 TO 15);
		R6: IN std_logic_vector(0 TO 15);
		R7: IN std_logic_vector(0 TO 15);
		B:OUT std_logic_vector(0 TO 15)
	);
END Component;

Component ALU IS
	PORT(
		A,B : IN std_logic_vector(0 TO 15);
		Operation: IN std_logic_vector(0 TO 2);
		S: OUT std_logic_vector(0 TO 15);
		Overflow : OUT std_logic
	);
End Component;

Component Regist IS
	GENERIC(n : IN POSITIVE := 16);
	PORT(
		I: IN std_logic_vector(0 TO (n-1));
		w, Clock: IN std_logic;
		O: OUT std_logic_vector(0 TO (n-1))
	);
END Component;

TYPE R_type IS ARRAY(0 to 7) OF std_logic_vector(0 to 15);
signal R : R_type;

Signal A, G, Gin, Add: std_logic_vector(0 TO 15);
Signal B_s: std_logic_vector(0 TO 15);
Signal IR: std_logic_vector(0 TO 8);
Signal Set: std_logic_vector(0 TO 13);
Signal Sel: std_logic_vector(0 TO 4);
Signal RSel: std_logic_vector(0 TO 2);
Signal Cout: std_logic;
BEGIN
	control0: Control port map(OP=>IR, Run=>Run, Reset=>Reset, Clock=>Clock, Set=>Set, Sel=>Sel, Done=>Done, State=>State, OPPrint=>OPPrint);
	mux0: Mux_Proc port map(Sel=>Sel, G=>G, DIN=>DIN, R0=>R(0), R1=>R(1), R2=>R(2), R3=>R(3), R4=>R(4), R5=>R(5), R6=>R(6), R7=>R(7), B=>B_s);
	alu0: ALU port map(A=>A, B=>B_s, Operation=>Set(3 TO 5), S=>Gin, Overflow=>Overflow);
	boucle: for i in 0 TO 7 generate
		reg0: Regist generic map(16) port map(I=>B_s, w=>Set(i+6), Clock=>Clock, O=>R(i));
	end generate boucle;
	regA: Regist generic map(16) port map(I=>B_s, w=>Set(1), Clock=>Clock, O=>A);
	regG: Regist generic map(16) port map(I=>Gin, w=>Set(2), Clock=>Clock, O=>G);
	ir0: Regist generic map(9) port map(I=>DIN(0 TO 8), w=>Set(0), Clock=>Clock, O=>IR);
	B <= B_s;
	addPrint <= Gin;
	R0 <= R(0);
	R1 <= R(1);
	R2 <= R(2);
	R3 <= R(3);
	whichWrite <= Set(6 TO 13);
END Behavior;