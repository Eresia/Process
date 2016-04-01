LIBRARY ieee;
USE ieee.std_logic_1164.all;
use ieee.numeric_std.all;

ENTITY Project IS
PORT(
	SW	:IN	STD_LOGIC_VECTOR(0 TO 17);
	LEDR:OUT STD_LOGIC_VECTOR(0 TO 17);
	LEDG:OUT	STD_LOGIC_VECTOR(0 TO 7);
	KEY:IN STD_LOGIC_VECTOR(0 TO 3);
	CLOCK_50: IN STD_LOGIC;
	MClock: IN STD_LOGIC;
	HEX0:OUT STD_LOGIC_VECTOR(0 TO 6);
	HEX1:OUT STD_LOGIC_VECTOR(0 TO 6);
	HEX2:OUT STD_LOGIC_VECTOR(0 TO 6);
	HEX3:OUT STD_LOGIC_VECTOR(0 TO 6);
	HEX4:OUT STD_LOGIC_VECTOR(0 TO 6);
	HEX5:OUT STD_LOGIC_VECTOR(0 TO 6);
	--HEX6:OUT STD_LOGIC_VECTOR(0 TO 6);
	HEX7:OUT STD_LOGIC_VECTOR(0 TO 6)
);
END Project;

ARCHITECTURE Behavior OF Project IS

Component Proc IS
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
	R0, R1, R2, R3: OUT std_logic_vector(0 TO 15)
);
END Component;

Component Memory_Test IS
PORT(
	Done, Reset: IN std_logic;
	result : OUT std_logic_vector(0 TO 15);
	instructionStates: OUT integer
);
END Component;

Component Counter IS
PORT
	(
		Clock, Reset : IN std_logic;
		instructionState : OUT integer;
		addr : OUT std_logic_vector( 4 DOWNTO 0)
	);
END Component;

Component rom IS
PORT
	(
		address		: IN STD_LOGIC_VECTOR (4 DOWNTO 0);
		clock		: IN STD_LOGIC;
		q		: OUT STD_LOGIC_VECTOR (15 DOWNTO 0)
	);
END Component;

Component segment_nombre_hexa IS
PORT(
	C: IN std_logic_vector(0 TO 3);
	O: OUT std_logic_vector(0 TO 6)
);
End Component;

Component segment_nombre_dec IS
PORT(
	C: IN Integer;
	O: OUT std_logic_vector(0 TO 6)
);
End Component;

component debouncer IS
	port(s_i, clk: IN std_logic;
			s_o: OUT std_logic);
end component;

signal so, nso: STD_LOGIC;
signal soR, nsoR: STD_LOGIC;
signal B: std_logic_vector(0 TO 15);
signal op: std_logic_vector(0 TO 3);
signal State: Integer;
signal OPPrint: std_logic_vector(0 TO 2);
signal whichWrite: std_logic_vector(0 TO 7);
signal Done: std_logic;
signal DIN: std_logic_vector(0 TO 15);
signal instructionStates: integer;
signal instUnit: integer;
signal instDiz: integer;
signal addPrint: std_logic_vector(0 TO 15);
signal manual: std_logic;
signal memoryResult: std_logic_vector(15 DOWNTO 0);
signal memoryResultInvers: std_logic_vector(0 TO 15);
signal R0, R1, R2, R3: std_logic_vector(0 TO 15);
signal s_addr_count : std_LOGIC_VECTOR(0 TO 4);
signal s_addr_memory : std_logic_vector(4 DOWNTO 0);
	
BEGIN
	debounc0 : debouncer PORT MAP (KEY(0), CLOCK_50, so);
	debounc1 : debouncer PORT MAP (KEY(1), CLOCK_50, soR);
	nso <= not so;
	nsoR <= not soR;
	proc0: Proc port map(Clock=>nso, Run=>SW(17), Reset=>soR, DIN=>DIN, Done=>Done, Overflow=>LEDG(7), B=>B, State=>State, OPPrint=>OPPrint, whichWrite=>whichWrite, 
				addPrint=>addPrint, R0=>R0, R1=>R1, R2=>R2, R3=>R3);
	
	--Notre compteur
	counter0 : Counter port map(Clock=>Done, Reset=> nsoR, addr=> s_addr_count, instructionState => instructionStates);
				
	--Notre mémoire
	memory_rom : rom port map(address=>s_addr_memory, clock=>Done, q=>memoryResult);
	--memory_test0 : Memory_Test port map(Done=>Done, Reset=>nsoR, result=>memoryResult, instructionStates=>instructionStates);
	
	--Mémoire auto :
	--memory0: Memory port map(clk_clk=>Done, reset_reset=>soR, sortie_readdata=>memoryResult);
	
	manual <= SW(16);
	
	with manual select
		DIN <= 	memoryResultInvers when '0',
					SW(0 TO 15) when '1';
	
	
	-------------------------------------------------------------Affichage
	--Affichage Bus
	seg0: segment_nombre_hexa port map(C=>B(0 TO 3), O=>HEX3);
	seg1: segment_nombre_hexa port map(C=>B(4 TO 7), O=>HEX2);
	seg2: segment_nombre_hexa port map(C=>B(8 TO 11), O=>HEX1);
	seg3: segment_nombre_hexa port map(C=>B(12 TO 15), O=>HEX0);
	
	--Affichage Resultat Addition
	--seg0: segment_nombre_hexa port map(C=>addPrint(0 TO 3), O=>HEX3);
	--seg1: segment_nombre_hexa port map(C=>addPrint(4 TO 7), O=>HEX2);
	--seg2: segment_nombre_hexa port map(C=>addPrint(8 TO 11), O=>HEX1);
	--seg3: segment_nombre_hexa port map(C=>addPrint(12 TO 15), O=>HEX0);
	
	--Affichage R0
	--seg0: segment_nombre_hexa port map(C=>R0(0 TO 3), O=>HEX3);
	--seg1: segment_nombre_hexa port map(C=>R0(4 TO 7), O=>HEX2);
	--seg2: segment_nombre_hexa port map(C=>R0(8 TO 11), O=>HEX1);
	--seg3: segment_nombre_hexa port map(C=>R0(12 TO 15), O=>HEX0);
	
	--Affichage R0-R1
	--seg0: segment_nombre_hexa port map(C=>R0(8 TO 11), O=>HEX3);
	--seg1: segment_nombre_hexa port map(C=>R0(12 TO 15), O=>HEX2);
	--seg2: segment_nombre_hexa port map(C=>R1(8 TO 11), O=>HEX1);
	--seg3: segment_nombre_hexa port map(C=>R1(12 TO 15), O=>HEX0);
	
	--Affichage R0-R1-R2
	--seg0: segment_nombre_hexa port map(C=>R0(12 TO 15), O=>HEX3);
	--seg1: segment_nombre_hexa port map(C=>R1(12 TO 15), O=>HEX2);
	--seg2: segment_nombre_hexa port map(C=>R2(8 TO 11), O=>HEX1);
	--seg3: segment_nombre_hexa port map(C=>R2(12 TO 15), O=>HEX0);
	
	countFor : for i in 0 TO 4 generate
		s_addr_memory(i) <= s_addr_count(4-i);
	end generate;
	
	memoryFor : for j in 0 TO 15 generate
		memoryResultInvers(j) <= memoryResult(15-j);
	end generate;
	
	--Affichage addresse
	--seg0: segment_nombre_hexa port map(C=>s_addr(1 TO 4), O=>HEX0);
	--seg1: segment_nombre_hexa port map(C=>("000" & s_addr(0)), O=>HEX1);
	--seg2: segment_nombre_hexa port map(C=>"0000", O=>HEX2);
	--seg3: segment_nombre_hexa port map(C=>"0000", O=>HEX3);
	
	--Affichage sortie
	--seg0: segment_nombre_hexa port map(C=>memoryResult2(0 TO 3), O=>HEX3);
	--seg1: segment_nombre_hexa port map(C=>memoryResult2(4 TO 7), O=>HEX2);
	--seg2: segment_nombre_hexa port map(C=>memoryResult2(8 TO 11), O=>HEX1);
	--seg3: segment_nombre_hexa port map(C=>memoryResult2(12 TO 15), O=>HEX0);
	
	-- Affichage OP
	op <= '0' & OPPrint;
	--seg4: segment_nombre_hexa port map(C=>op, O=>HEX4);
	
	--Affichage nbOperation	
	with instructionStates select
		instUnit <= 	9 when -1,
							instructionStates mod 10 when OTHERS;
							
	with instructionStates select
		instDiz <= 	9 when -1,
						instructionStates / 10 when OTHERS;
	
	seg4: segment_nombre_dec port map(C=>instUnit, O=>HEX4);
	seg5: segment_nombre_dec port map(C=>instDiz, O=>HEX5);
	seg7: segment_nombre_dec port map(C=>State, O=>HEX7);
	
	----Affichage du Registre sur lequel on écrit
	LEDR(0 TO 7) <= whichWrite;
	
	--Affichage Clock/Reset
	LEDR(17) <= nso;
	LEDR(16) <= nsoR;
	
	--Affichage Run
	LEDR(15) <= SW(17);
	
	--Affichage Done
	LEDG(0) <= Done;
END Behavior;