LIBRARY ieee; USE ieee.std_logic_1164.all;
USE ieee.std_logic_signed.all;

-- Done
ENTITY Control IS
PORT(
	OP: IN std_logic_vector(0 TO 8);
	Run, Reset, Clock: IN std_logic;
	Set: OUT std_logic_vector(0 TO 13);
	Sel: OUT std_logic_vector(0 TO 4);
	Done: OUT std_logic;
	State: OUT Integer;
	OPPrint: OUT std_logic_vector(0 TO 2)
);
END Control;

Architecture Behavior OF Control IS

Component Demux IS
PORT(
	I: IN std_logic_vector(0 TO 2);
	O: OUT std_logic_vector(0 TO 7)
);
END Component;

Signal Cs: Integer;
Signal Ns, Ts: Integer;
Signal Rx: std_logic_vector(0 To 7);
Signal DemI: std_logic_vector(0 TO 2);
Signal DemO: std_logic_vector(0 TO 7);
BEGIN
	demux0: Demux port map(I=>DemI, O=>DemO);
	
	with op(0 TO 2) select
		Ts <= 	3 when "000",
					4 when "001",
					6 when "010",
					9 when "011",
					11 when "100",
					13 when "101",
					15 when "110",
					0 when OTHERS;
	
	NSL: PROCESS(Cs, OP, Run)
	BEGIN
		if run='1' then
			case Cs is
				when 0 =>
					Ns <= 1;
				when 1 =>
					Ns <= 2;
				when 2 =>
					Ns <= Ts;
				when 3 =>
					Ns <= 1;
				when 4 =>
					Ns <= 5;
				when 5 =>
					Ns <= 1;
				when 6 =>
					Ns <= 7;
				when 7 =>
					Ns <= 8;
				when 8 =>
					Ns <= 1;
				when 9 =>
					Ns <= 10;
				when 10 =>
					Ns <= 8;
				when 11 =>
					Ns <= 12;
				when 12 =>
					Ns <= 8;
				when 13 =>
					Ns <= 14;
				when 14 =>
					Ns <= 8;
				when 15 =>
					Ns <= 8;
				when OTHERS => NULL;
			end case;
		end if;
	END Process;
	
	OL: PROCESS(Cs, OP)
	BEGIN
		Set <= "00000000000000";
		Sel <= "00000";
		Done <= '0';
		if run='1' then
			case Cs is
				when 1 =>
					Set(0) <= '1';
					Done <= '1';
				when 3 =>
					Sel(2 TO 4) <= OP(3 TO 5);
					DemI <= OP(6 TO 8);
					Set(6 TO 13) <= DemO;
				when 4 =>
					Done <= '1';
				when 5 =>
					Sel(1) <= '1';
					DemI <= OP(3 TO 5);
					Set(6 TO 13) <= DemO;
				when 6 =>
					Sel(2 TO 4) <= OP(3 TO 5);
					Set(1) <= '1';
				when 7 =>
					Sel(2 TO 4) <= OP(6 TO 8);
					Set(2) <= '1';
					Set(3 TO 5) <= "001";
				when 8 =>
					Sel(0) <= '1';
					DemI <= OP(3 TO 5);
					Set(6 TO 13) <= DemO;
				when 9 =>
					Sel(2 TO 4) <= OP(3 TO 5);
					Set(1) <= '1';
				when 10 =>
					Sel(2 TO 4) <= OP(6 TO 8);
					Set(2) <= '1';
					Set(3 TO 5) <= "000";
				when 11 =>
					Sel(2 TO 4) <= OP(3 TO 5);
					Set(1) <= '1';
				when 12 =>
					Sel(2 TO 4) <= OP(6 TO 8);
					Set(2) <= '1';
					Set(3 TO 5) <= "010";
				when 13 =>
					Sel(2 TO 4) <= OP(3 TO 5);
					Set(1) <= '1';
				when 14 =>
					Sel(2 TO 4) <= OP(6 TO 8);
					Set(2) <= '1';
					Set(3 TO 5) <= "011";
				when 15 =>
					Sel(2 TO 4) <= OP(3 TO 5);
					Set(2) <= '1';
					Set(3 TO 5) <= "100";
				when OTHERS => NULL;
			end case;
		end if;
	END Process;
	
	SM: PROCESS(Reset, Clock)
	BEGIN
		if Reset = '0' then
			Cs <= 0;
		else
			if (Clock'event and Clock = '1') then
				Cs <= Ns;
			end if;
		end if;
	END Process;

	State <= Cs;
	OPPrint <= OP(0 to 2);

END Behavior;